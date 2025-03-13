package com.xinwen.jgrapht.controller;

/**
 * @author shenlx
 * @description
 * @date 2025/3/13 11:40
 */

import com.xinwen.jgrapht.common.BadRequestException;
import com.xinwen.jgrapht.common.ResourceNotFoundException;
import com.xinwen.jgrapht.pojo.City;
import com.xinwen.jgrapht.pojo.TransportData;
import com.xinwen.jgrapht.service.PathOptimizer;
import com.xinwen.jgrapht.service.TransportationNetworkService;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
  * 传输控制器类，提供RESTful API接口。
  */
@RestController
@RequestMapping("/api/transport")
public class TransportController {

    private final Logger logger = LoggerFactory.getLogger(TransportController.class);

    @Autowired
    private TransportationNetworkService networkService;

    @Autowired
    private PathOptimizer pathOptimizer;

    /**
      * 构建交通网络。
      *
      * @param data 包含城市和道路信息的传输数据
      * @param bindingResult 绑定结果，用于验证输入数据
      * @return 成功响应
      * @throws BadRequestException 如果输入数据无效
      */
    @PostMapping("/build-network")
    public ResponseEntity<Void> buildNetwork(@Valid  @RequestBody TransportData data, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("验证错误: {}", bindingResult.getAllErrors());
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }

        try {
            networkService.buildNetwork(data.getCities(), data.getRoads());
            logger.info("交通网络构建成功");
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("构建交通网络时出错: ", e);
            throw new BadRequestException(e.getMessage());
        }
    }

    /**
      * 计算最小生成树（MST）。
      *
      * @return 最小生成树的边集合
      */
    @GetMapping("/compute-mst")
    public ResponseEntity<List<DefaultWeightedEdge>> computeMST() {
        Set<DefaultWeightedEdge> mstEdges = pathOptimizer.computeMST();
        List<DefaultWeightedEdge> defaultWeightedEdges = List.copyOf(mstEdges);
        logger.info("计算得到的MST边集: {}", mstEdges);
        return ResponseEntity.ok(defaultWeightedEdges);
    }

    /**
      * 计算最短路径。
      *
      * @param sourceId 源城市ID
      * @param targetId 目标城市ID
      * @return 最短路径对象
      * @throws ResourceNotFoundException 如果找不到对应的源或目标城市
      */
            @GetMapping("/GraphPath/shortest-path/{sourceId}/{targetId}")
    public ResponseEntity<GraphPath<City, DefaultWeightedEdge>> computeGraphPathShortestPath(
            @PathVariable String sourceId,
            @PathVariable String targetId) {
        City source = networkService.findCityById(sourceId);
        City target = networkService.findCityById(targetId);

                GraphPath<City, DefaultWeightedEdge> path =
                        pathOptimizer.computeGraphPathShortestPath(source, target);
                logger.info("计算得到的最短路径: {}", path);
        return ResponseEntity.ok(path);
    }

    /**
     * 计算最短路径。
     *
     * @param sourceId 源城市ID
     * @param targetId 目标城市ID
     * @return 最短路径对象
     * @throws ResourceNotFoundException 如果找不到对应的源或目标城市
     */
    @GetMapping("/shortest-path/{sourceId}/{targetId}")
    public ResponseEntity<DijkstraShortestPath<City, DefaultWeightedEdge>> computeShortestPath(
            @PathVariable String sourceId,
            @PathVariable String targetId) {
        City source = networkService.findCityById(sourceId);
        City target = networkService.findCityById(targetId);

        DijkstraShortestPath<City, DefaultWeightedEdge> path = pathOptimizer.computeShortestPath(source, target);
        logger.info("计算得到的最短路径: {}", path);
        return ResponseEntity.ok(path);
    }

}

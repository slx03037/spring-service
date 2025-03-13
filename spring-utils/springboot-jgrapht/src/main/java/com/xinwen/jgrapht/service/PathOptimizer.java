package com.xinwen.jgrapht.service;

import com.xinwen.jgrapht.pojo.City;
import lombok.extern.slf4j.Slf4j;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author shenlx
 * @description 路径优化服务类，使用图论算法计算最优路径
 * @date 2025/3/13 11:20
 */

@Service
@Slf4j
public class PathOptimizer {

    @Autowired
    private TransportationNetworkService networkService;

    /**
     * 计算最小生成树（MST）
     * @return
     */
    public Set<DefaultWeightedEdge> computeMST(){
        log.info("正在计算最小生成叔(MST)");
        /**
         * 最小生成树（Minimum Spanning Tree - MST）
         * 最小生成树是指在一个加权无向图中，选取一些边组成一棵树，使得该树的所有顶点都属于原图，并且所有边都在原图中，同时这些边的总权重最小。
         */
        KruskalMinimumSpanningTree<City, DefaultWeightedEdge> mstAlg
                = new KruskalMinimumSpanningTree<>(networkService.getGraph());
        return mstAlg.getSpanningTree().getEdges();
    }

    /**
     * 使用Dijkstra算法计算最短路径
     * @param source
     * @param target
     * @return
     */
    public GraphPath<City,DefaultWeightedEdge> computeGraphPathShortestPath(City source,City target){
        log.info("正在计算从{}到{}的最短路径",source.getName(),target.getName());


        DijkstraShortestPath<City, DefaultWeightedEdge> dijkstragAlg
                = new DijkstraShortestPath<>(networkService.getGraph());
        return dijkstragAlg.getPath(source, target);
    }

    public DijkstraShortestPath<City,DefaultWeightedEdge> computeShortestPath(City source,City target){
        log.info("正在计算从{}到{}的最短路径",source.getName(),target.getName());


        DijkstraShortestPath<City, DefaultWeightedEdge> dijkstragAlg
                = new DijkstraShortestPath<>(networkService.getGraph());
        return dijkstragAlg;
    }
}

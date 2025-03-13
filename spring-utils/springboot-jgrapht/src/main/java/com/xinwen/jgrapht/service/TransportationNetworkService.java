package com.xinwen.jgrapht.service;

import com.xinwen.jgrapht.common.BadRequestException;
import com.xinwen.jgrapht.common.ResourceNotFoundException;
import com.xinwen.jgrapht.pojo.City;
import com.xinwen.jgrapht.pojo.Road;
import lombok.extern.slf4j.Slf4j;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shenlx
 * @description 交通网络服务类，负责构建和管理图模型。
 * @date 2025/3/13 11:02
 */

@Service
@Slf4j
public class TransportationNetworkService {

    private final Map<String, City> cityMap=new HashMap<>();
    private final Graph<City, DefaultWeightedEdge> graph;


    /**
     * 初始化图像
     */
    public TransportationNetworkService(){
        this.graph=new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
    }

    /**
     * 根据输入的城市和道路信息构建图模型
     * @param cities
     * @param roads
     */
    public void buildNetwork(List<City>cities, List<Road> roads){
        log.info("正在构建包含:{}个城市和{}条道路的交通网络",cities.size(),roads.size());
        for (City city:cities){
            if (!cityMap.containsKey(city.getId())){
                graph.addVertex(city);
                cityMap.put(city.getId(),city);
            }else {
                throw new BadRequestException("重复的城市ID："+city.getId());
            }
        }


        for(Road road:roads){
            City source = cityMap.get(road.getSourceId());
            City target = cityMap.get(road.getTargetId());
            if(source==null || target == null){
                throw new BadRequestException("无效的道路连接城市："+road.getSourceId()+"和"+road.getTargetId());
            }
            graph.addVertex(source);
            graph.addVertex(target);
            DefaultWeightedEdge edge=graph.addEdge(source,target);
            graph.setEdgeWeight(edge,road.getWeight());
        }
    }


    /**
     * 获取当前构建的图模型
     * @return 图模型
     */
    public Graph<City,DefaultWeightedEdge>getGraph(){
        return graph;
    }

    /**
     * 根据城市ID查找城市对象
     * @param id
     * @return
     */
    public City findCityById(String id){
        City city = cityMap.get(id);

        if (city==null){
            throw  new ResourceNotFoundException("未找到ID为"+id+"的城市");
        }
        return city;
    }
}

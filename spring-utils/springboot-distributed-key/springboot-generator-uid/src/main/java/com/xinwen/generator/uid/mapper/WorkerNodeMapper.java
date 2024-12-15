package com.xinwen.generator.uid.mapper;


import com.xinwen.generator.uid.entity.WorkerNode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 17:13
 */
@Mapper
public interface WorkerNodeMapper {
    int addWorkerNode(WorkerNode workerNodeEntity);


    WorkerNode getWorkerNodeByHostPort(@Param("host") String host, @Param("port") String port);
}

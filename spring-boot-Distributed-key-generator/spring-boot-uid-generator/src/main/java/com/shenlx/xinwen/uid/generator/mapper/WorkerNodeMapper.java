package com.shenlx.xinwen.uid.generator.mapper;

import com.shenlx.xinwen.uid.generator.entity.WorkerNode;
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

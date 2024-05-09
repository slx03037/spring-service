package com.shenlx.xinwen.uid.generator.config;

import com.shenlx.xinwen.uid.generator.entity.WorkerNode;
import com.shenlx.xinwen.uid.generator.mapper.WorkerNodeMapper;
import com.xfvape.uid.utils.DockerUtils;
import com.xfvape.uid.utils.NetUtils;
import com.xfvape.uid.worker.WorkerIdAssigner;
import com.xfvape.uid.worker.WorkerNodeType;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author shenlx
 * @description 重写WorkerIdAssigner接口
 * @date 2024/5/9 17:17
 */
public class DisposableWorkerIdAssigner implements WorkerIdAssigner {
    @Resource
    private WorkerNodeMapper workerNodeMapper;
    @Override
    @Transactional
    public long assignWorkerId() {
        WorkerNode workerNode = buildWorkerNode();

        workerNodeMapper.addWorkerNode(workerNode);

        return workerNode.getId();
    }

    private WorkerNode buildWorkerNode() {
        WorkerNode workNode = new WorkerNode();
        if (DockerUtils.isDocker()) {
            workNode.setType(WorkerNodeType.CONTAINER.value());
            workNode.setHostName(DockerUtils.getDockerHost());
            workNode.setPort(DockerUtils.getDockerPort());
            workNode.setLaunchDate(new Date());
        } else {
            workNode.setType(WorkerNodeType.ACTUAL.value());
            workNode.setHostName(NetUtils.getLocalAddress());
            workNode.setPort(System.currentTimeMillis() + "-" + RandomUtils.nextInt(100000));
            workNode.setLaunchDate(new Date());
        }

        return workNode;
    }
}

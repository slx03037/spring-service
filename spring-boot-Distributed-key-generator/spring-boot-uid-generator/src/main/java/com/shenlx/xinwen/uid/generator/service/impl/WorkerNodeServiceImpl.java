package com.shenlx.xinwen.uid.generator.service.impl;

import com.shenlx.xinwen.uid.generator.service.IWorkerNodeService;
import com.xfvape.uid.UidGenerator;

import javax.annotation.Resource;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 17:16
 */
public class WorkerNodeServiceImpl implements IWorkerNodeService {
    @Resource
    private UidGenerator uidGenerator;

    @Override
    public long genUid() {
        return uidGenerator.getUID();
    }
}

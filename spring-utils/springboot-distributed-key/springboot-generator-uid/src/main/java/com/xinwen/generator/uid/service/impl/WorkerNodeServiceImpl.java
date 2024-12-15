package com.xinwen.generator.uid.service.impl;



import com.xfvape.uid.UidGenerator;
import com.xinwen.generator.uid.service.IWorkerNodeService;

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

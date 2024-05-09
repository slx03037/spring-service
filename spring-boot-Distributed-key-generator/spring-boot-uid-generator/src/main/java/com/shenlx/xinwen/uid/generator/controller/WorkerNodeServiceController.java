package com.shenlx.xinwen.uid.generator.controller;

import com.shenlx.xinwen.uid.generator.service.IWorkerNodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 17:18
 */
@RestController
public class WorkerNodeServiceController {
    @Resource
    private IWorkerNodeService workerNodeService;
    /**
     * 集成百度uid-generator生成id
     * @return
     */
    @GetMapping("/baidu/uid")
    public long baiduUid(){
        return workerNodeService.genUid();
    }
}

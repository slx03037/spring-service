package com.xinwen.demo.node06.sdk.service;

import com.xinwen.demo.node06.sdk.entity.PoJo;
import com.xinwen.demo.node06.sdk.model.Result;

/**
 * @author shenlx
 * @description
 * @date 2025/1/14 16:14
 */
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHello(String name) {
        return "mock value";
    }

    @Override
    public Result<String> testGeneric(PoJo poJo) {
        return null;
    }
}

package com.xinwen.demo.node01.sdk.service;

import com.xinwen.demo.node01.sdk.entity.PoJo;
import com.xinwen.demo.node01.sdk.model.Result;

/**
 * @author shenlx
 * @description
 * @date 2025/1/7 17:22
 */
public interface GreetingService {
    String sayHello(String name);

    Result<String> testGeneric(PoJo poJo);
}

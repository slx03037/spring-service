package com.xinwen.demo.node04.sdk.service;



import com.xinwen.demo.node04.sdk.model.Result;
import com.xinwen.demo.node04.sdk.entity.PoJo;

/**
 * @author shenlx
 * @description
 * @date 2025/1/7 17:22
 */
public interface GreetingService {
    String sayHello(String name);

    Result<String> testGeneric(PoJo poJo);
}

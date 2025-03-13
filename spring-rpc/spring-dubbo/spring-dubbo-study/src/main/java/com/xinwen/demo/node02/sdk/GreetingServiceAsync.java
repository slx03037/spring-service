package com.xinwen.demo.node02.sdk;

import com.xinwen.demo.node01.sdk.entity.PoJo;

import java.util.concurrent.CompletableFuture;

/**
 * @author shenlx
 * @description
 * @date 2025/1/7 17:26
 */
public interface GreetingServiceAsync {
    CompletableFuture<PoJo> sayHello(String name);

}

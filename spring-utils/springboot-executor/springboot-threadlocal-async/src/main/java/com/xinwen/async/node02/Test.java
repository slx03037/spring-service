package com.xinwen.async.node02;

import com.xinwen.async.common.OauthContext;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * @author shenlx
 * @description
 * @date 2025/2/13 15:03
 */
@Slf4j
public class Test {
    public void handleAsync(){
       log.warn("父线程的用户信息:{}", OauthContext.get());
       //执行异步任务，需要指定的线程池
        CompletableFuture.runAsync(()->{log.warn("子线程的用户信息:{}",OauthContext.get());});
    }

}

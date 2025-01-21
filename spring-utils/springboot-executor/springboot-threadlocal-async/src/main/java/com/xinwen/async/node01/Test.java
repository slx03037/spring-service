package com.xinwen.async.node01;

import com.xinwen.async.common.LoginVal;
import com.xinwen.async.common.OauthContext;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * @author shenlx
 * @description
 * @date 2025/2/12 12:03
 */
@Slf4j
public class Test {
    public static void main(String[]args){
        new Test().handlerAsync();
    }

    /**
     * 1. 手动设置每执行一次异步线程都要分为两步：获取父线程的LoginVal将LoginVal设置到子线程，达到复用
     */
    public void handlerAsync(){
        //1.获取父线程的loginVal
        LoginVal loginVal = OauthContext.get();
        log.warn("父线程的值:{}",OauthContext.get());
        CompletableFuture.runAsync(()->{
           //2.设置子线程的值，复用
            OauthContext.set(loginVal);
            log.warn("子线程的值:{}",OauthContext.get());
        });
    }



}

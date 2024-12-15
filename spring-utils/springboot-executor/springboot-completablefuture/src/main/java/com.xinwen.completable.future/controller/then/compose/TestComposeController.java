package com.xinwen.completable.future.controller.then.compose;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * @author shenlx
 * @description
 * @date 2024/5/20 17:55
 */
@RestController
@Slf4j
@RequestMapping("test")
public class TestComposeController {
    public void thenCompose1() {
        CompletableFuture<Integer> stringCompletableFuture = CompletableFuture.supplyAsync(() -> 4)
                .thenCompose(value -> CompletableFuture.supplyAsync(() -> {
                    // thenCompose方法返回一个新的CompletableFuture
                    if (Integer.valueOf(4).equals(value)) {
                        return 66;
                    } else {
                        return 99;
                    }
                }));
        log.info("结果：" + stringCompletableFuture.join());

    }

    public void thenCompose() {
        CompletableFuture<String> first = CompletableFuture.completedFuture("第一个任务");
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> 4)
                .thenCompose((data) -> {
                    log.info("data为：" + data);
                    return first;
                });
        log.info("结果：" + stringCompletableFuture.join());

    }
}

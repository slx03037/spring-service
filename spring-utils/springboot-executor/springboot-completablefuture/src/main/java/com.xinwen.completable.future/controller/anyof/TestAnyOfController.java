package com.xinwen.completable.future.controller.anyof;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * @author shenlx
 * @description
 * @date 2024/5/20 17:51
 */
@RestController
@Slf4j
@RequestMapping("test")
public class TestAnyOfController {

    // 前提任务任意执行完一个，则目标任务执行。其他前提任务则不在执行。
// 任意一个任务执行完，就执行anyOf返回的CompletableFuture。如果执行的任务异常，anyOf的CompletableFuture，执行get方法，会抛出异常。
    @GetMapping("/any/of")
    public void anyOf() {
        CompletableFuture<Void> first = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("第一个任务执行完成！");
        });
        CompletableFuture<Void> second = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("第二个任务执行完成！");
        });
        CompletableFuture<Object> voidCompletableFuture = CompletableFuture.anyOf(first, second).whenComplete((m, n) -> {
            log.info("第三个任务完成！");
        });
        voidCompletableFuture.join();
    }
}

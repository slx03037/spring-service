package com.xinwen.completable.future.controller.allof;


import com.xinwen.completable.future.dao.DeptRepository;
import com.xinwen.completable.future.dao.MenuRepository;
import com.xinwen.completable.future.dao.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

/**
 * @author shenlx
 * @description
 * @date 2024/5/20 17:42
 */
@RestController
@Slf4j
@RequestMapping("test")
public class TestOffController {
    @Resource
    private UserRepository userRepository;

    @Resource
    private MenuRepository menuRepository;

    @Resource
    private DeptRepository deptRepository;
    // 所有任务都执行完成后，才执行 allOf返回的CompletableFuture。如果任意一个任务异常，allOf的CompletableFuture，执行get方法，会抛出异常。
// 这里第一次执行没有睡眠的话，是可以直接执行第三个任务的。如果有睡眠，则需要手动join启动。
    public void allOf() {
        CompletableFuture<Void> first = CompletableFuture.runAsync(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            log.info("第一个任务执行完成！");
        });
        CompletableFuture<Void> second = CompletableFuture.runAsync(() -> {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            log.info("第二个任务执行完成！");
        });
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(first, second).whenComplete((m, n) -> {
            log.info("第三个任务完成！");
        });
//        voidCompletableFuture.join();
    }

    @GetMapping("/all/of")
    public void defaultAllOf(){
        CompletableFuture<Void> firstCompletableFuture = CompletableFuture.runAsync(() -> {
            log.info("第一个任务执行完成！");
        });

        CompletableFuture<Void> secondCompletableFuture = CompletableFuture.runAsync(() -> {
            log.info("第二个任务执行完成！");
        });

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(firstCompletableFuture, secondCompletableFuture);
        voidCompletableFuture.whenComplete((m,n)->{
            log.info("m:{},n:{}",m,n);
            log.info("第三个任务完成！");
        });
    }

    @GetMapping("/all/of2")
    public void defaultAllOf2(){
        CompletableFuture<String> firstCompletableFuture = CompletableFuture.supplyAsync(() -> {
            log.info("第一个任务执行完成！");
            return "1";
        });

        CompletableFuture<String> secondCompletableFuture = CompletableFuture.supplyAsync(() -> {
            log.info("第二个任务执行完成！");
            return "2";
        });

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(firstCompletableFuture, secondCompletableFuture);
        voidCompletableFuture.whenComplete((m,n)->{
            //log.info("m:{},n:{}",m,n);
            log.info("第三个任务完成！");
        });
    }

    @GetMapping("/all/of3")
    public void defaultAllOf3(){
        CompletableFuture<String> firstCompletableFuture = CompletableFuture.supplyAsync(() -> {
            log.info("第一个任务执行完成！");
            return "1";
        });

        CompletableFuture<String> secondCompletableFuture = CompletableFuture.supplyAsync(() -> {
            log.info("第二个任务执行完成！");
            return "2";
        });

        CompletableFuture<String> thirdCompletableFuture = CompletableFuture.supplyAsync(() -> {
            log.info("第三个任务执行完成！");
            return "3";
        });


        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(firstCompletableFuture, secondCompletableFuture,thirdCompletableFuture);
        voidCompletableFuture.whenComplete((m,n)->{
            //log.info("m:{},n:{}",m,n);
            log.info("所有任务完成！");
        });
    }
}

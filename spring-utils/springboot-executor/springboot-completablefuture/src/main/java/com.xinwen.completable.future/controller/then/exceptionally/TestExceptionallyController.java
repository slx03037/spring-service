package com.xinwen.completable.future.controller.then.exceptionally;

import com.xinwen.completable.future.dao.DeptRepository;
import com.xinwen.completable.future.dao.MenuRepository;
import com.xinwen.completable.future.dao.UserRepository;
import com.xinwen.completable.future.entity.Dept;
import com.xinwen.completable.future.entity.Menu;
import com.xinwen.completable.future.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author shenlx
 * @description
 * @date 2024/5/20 14:35
 */
@RestController
@Slf4j
@RequestMapping("test")
public class TestExceptionallyController {
    @Resource
    private UserRepository userRepository;

    @Resource
    private MenuRepository menuRepository;

    @Resource
    private DeptRepository deptRepository;

    @GetMapping("save/exceptionally")
    // 某个任务执行异常时，执行的回调方法;并且有抛出异常作为参数，传递到回调方法。
    public void exceptionally() throws ExecutionException, InterruptedException {
        long lordStartTime = System.currentTimeMillis();
        CompletableFuture<User> completableFuture = CompletableFuture.supplyAsync(() -> {
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            User user = new User("张三1", 10, 1);
            User save = userRepository.save(user);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}", Thread.currentThread().getName(), Thread.currentThread().getId());
            log.info("内部新增用户耗时:" + (endTime - startTime) / 1000 + "秒");
            log.info("新增用户耗时:" + (endTime - lordStartTime) / 1000 + "秒");
            return save;
        });
        CompletableFuture<Dept> errorCompletableFuture = completableFuture.thenApply((user) -> {
            log.warn("用户信息");
            if(true){
                /**
                 * 这里的异常一定要抛出来，不然exceptionally无效
                 */
                throw  new RuntimeException("error------");
            }
            return null;
        } );

        CompletableFuture<Menu> menuCompletableFuture = completableFuture.thenApply((user) -> {
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Menu menu = new Menu("dept", "部门");
            Menu save = menuRepository.save(menu);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}", Thread.currentThread().getName(), Thread.currentThread().getId());
            log.info("内部菜单用户耗时:" + (endTime - startTime) / 1000 + "秒");
            log.info("新增菜单耗时:" + (endTime - lordStartTime) / 1000 + "秒");
            return save;
        });

        CompletableFuture<Dept> thenCompletableFuture = errorCompletableFuture.thenApply((map) -> {
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Dept dept = new Dept("boss", "ceo", 0L);
            Dept save = deptRepository.save(dept);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}", Thread.currentThread().getName(), Thread.currentThread().getId());
            log.info("内部部门用户耗时:" + (endTime - startTime) / 1000 + "秒");
            log.info("新增部门耗时:" + (endTime - lordStartTime) / 1000 + "秒");
            return save;
        });

        CompletableFuture<Dept> exceptionFuture1 = errorCompletableFuture.exceptionally((e) -> {
            long startTime = System.currentTimeMillis();
            log.error("报错信息1111:{}",e.getMessage());
            Dept dept = new Dept("boss", "ceo", 0L);
            Dept save = deptRepository.save(dept);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}", Thread.currentThread().getName(), Thread.currentThread().getId());
            log.info("内部部门用户耗时:" + (endTime - startTime) / 1000 + "秒");
            log.info("新增部门耗时:" + (endTime - lordStartTime) / 1000 + "秒");
            return save;
        });

        CompletableFuture<User> exceptionFuture = completableFuture.exceptionally((e) -> {
            log.error("报错信息:{}",e.getMessage());
            User user = new User("张三2", 10, 1);
            return user;
        });
        log.info("用户信息：{}" , completableFuture.get());
        log.info("菜单信息:{}",menuCompletableFuture.get());
        log.info("部门信息:{}",exceptionFuture1.get());
        exceptionFuture.get();
        log.info("总耗时:" + (System.currentTimeMillis() - lordStartTime) / 1000 + "秒");
    }

}

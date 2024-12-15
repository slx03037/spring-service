package com.xinwen.completable.future.controller.then.accept;

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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author shenlx
 * @description
 * @date 2024/5/20 13:48
 */
@RestController
@Slf4j
@RequestMapping("test")
public class TestThenAcceptController {

    @Resource
    private UserRepository userRepository;

    @Resource
    private MenuRepository menuRepository;

    @Resource
    private DeptRepository deptRepository;

    @GetMapping("save/then/accept")
    // 执行第一个任务后 可以继续执行第二个任务 并携带第一个任务的返回值 第二个任务执行完没有返回值
    public void defaultThenAccept() throws ExecutionException, InterruptedException {
        long lordStartTime = System.currentTimeMillis();
        CompletableFuture<User> userCompletableFuture = CompletableFuture.supplyAsync(() -> {
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            User user = new User("张三1", 10, 1);
            User save = userRepository.save(user);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("内部新增用户耗时:" + (endTime - startTime) / 1000 + "秒");
            log.info("新增用户耗时:" + (endTime - lordStartTime) / 1000 + "秒");
            return save;
        });
        CompletableFuture<Void> deptCompletableFuture = userCompletableFuture.thenAccept((user) -> {
            long startTime = System.currentTimeMillis();
            log.info("用户信息:{}",user);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Dept dept = new Dept("boss", "ceo", 0L);
            Dept save = deptRepository.save(dept);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("内部部门用户耗时:" + (endTime - startTime) / 1000 + "秒");
            log.info("新增部门耗时:" + (endTime - lordStartTime) / 1000 + "秒");
        });
        CompletableFuture<Void> menuCompletableFuture = deptCompletableFuture.thenRunAsync(() -> {
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Menu menu = new Menu("dept", "部门");
            Menu save = menuRepository.save(menu);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("内部菜单用户耗时:" + (endTime - startTime) / 1000 + "秒");
            log.info("新增菜单耗时:" + (endTime - lordStartTime) / 1000 + "秒");
        });
        deptCompletableFuture.get();
        menuCompletableFuture.get();
        log.info("总耗时:" + (System.currentTimeMillis() - lordStartTime) / 1000 + "秒");

    }

    @GetMapping("save/then/accept1")
    // 执行第一个任务后 可以继续执行第二个任务 并携带第一个任务的返回值 第二个任务执行完没有返回值
    public void defaultThenAccept1() throws ExecutionException, InterruptedException {
        long lordStartTime = System.currentTimeMillis();
        CompletableFuture<User> userCompletableFuture = CompletableFuture.supplyAsync(() -> {
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            User user = new User("张三1", 10, 1);
            User save = userRepository.save(user);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("内部新增用户耗时:" + (endTime - startTime) / 1000 + "秒");
            log.info("新增用户耗时:" + (endTime - lordStartTime) / 1000 + "秒");
            return save;
        });
        CompletableFuture<Void> deptCompletableFuture = userCompletableFuture.thenAccept((user) -> {
            long startTime = System.currentTimeMillis();
            log.info("用户信息:{}",user);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Dept dept = new Dept("boss", "ceo", 0L);
            Dept save = deptRepository.save(dept);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("内部部门用户耗时:" + (endTime - startTime) / 1000 + "秒");
            log.info("新增部门耗时:" + (endTime - lordStartTime) / 1000 + "秒");
        });
        CompletableFuture<Void> menuCompletableFuture = deptCompletableFuture.thenRunAsync(() -> {
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Menu menu = new Menu("dept", "部门");
            Menu save = menuRepository.save(menu);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("内部菜单用户耗时:" + (endTime - startTime) / 1000 + "秒");
            log.info("新增菜单耗时:" + (endTime - lordStartTime) / 1000 + "秒");
        });
        deptCompletableFuture.get();
        menuCompletableFuture.get();
        log.info("总耗时:" + (System.currentTimeMillis() - lordStartTime) / 1000 + "秒");

    }

    @GetMapping("save/then/accept2")
    // 执行第一个任务后 可以继续执行第二个任务 并携带第一个任务的返回值 第二个任务执行完没有返回值
    public void defaultThenAccept2() throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        long lordStartTime = System.currentTimeMillis();
        CompletableFuture<User> userCompletableFuture = CompletableFuture.supplyAsync(() -> {
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            User user = new User("张三1", 10, 1);
            User save = userRepository.save(user);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("内部新增用户耗时:" + (endTime - startTime) / 1000 + "秒");
            log.info("新增用户耗时:" + (endTime - lordStartTime) / 1000 + "秒");
            return save;
        },scheduledExecutorService);

        CompletableFuture<Void> deptCompletableFuture = userCompletableFuture.thenAcceptAsync((user) -> {
            long startTime = System.currentTimeMillis();
            log.info("用户信息:{}",user);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Dept dept = new Dept("boss", "ceo", 0L);
            Dept save = deptRepository.save(dept);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("内部部门用户耗时:" + (endTime - startTime) / 1000 + "秒");
            log.info("新增部门耗时:" + (endTime - lordStartTime) / 1000 + "秒");
        },scheduledExecutorService);

        CompletableFuture<Void> menuCompletableFuture = deptCompletableFuture.thenRunAsync(() -> {
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Menu menu = new Menu("dept", "部门");
            Menu save = menuRepository.save(menu);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("内部菜单用户耗时:" + (endTime - startTime) / 1000 + "秒");
            log.info("新增菜单耗时:" + (endTime - lordStartTime) / 1000 + "秒");
        });
        deptCompletableFuture.get();
        menuCompletableFuture.get();
        log.info("总耗时:" + (System.currentTimeMillis() - lordStartTime) / 1000 + "秒");
    }
}

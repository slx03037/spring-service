package com.xinwen.completable.future.controller.then.run;

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
import java.util.concurrent.*;

/**
 * @author shenlx
 * @description
 * @date 2024/5/20 13:42
 */
@RestController
@Slf4j
@RequestMapping("test")
public class TestThenRunController {

    @Resource
    private UserRepository userRepository;

    @Resource
    private MenuRepository menuRepository;

    @Resource
    private DeptRepository deptRepository;

    @GetMapping("save/then/run")
    // 执行第一个任务后 可以继续执行第二个任务 两个任务之间无传参 无返回值
    public void defaultThenRun() throws ExecutionException, InterruptedException {
        long lordStartTime = System.currentTimeMillis();
        //ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        CompletableFuture<Void> userCompletableFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            User user = new User("张三1", 10, 1);
            User save = userRepository.save(user);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("新增用户耗时:" + (endTime - lordStartTime) / 1000 + "秒");
        });
        CompletableFuture<Void> thenCompletableFuture = userCompletableFuture.thenRun(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Dept dept = new Dept("boss", "ceo", 0L);
            Dept save = deptRepository.save(dept);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("新增部门耗时:" + (endTime - lordStartTime) / 1000 + "秒");
        });
        thenCompletableFuture.get();
        log.info("总耗时:" + (System.currentTimeMillis() - lordStartTime) / 1000 + "秒");

    }

    @GetMapping("save/then/run2")
    // 执行第一个任务后 可以继续执行第二个任务 两个任务之间无传参 无返回值
    public void defaultThenRun2() throws ExecutionException, InterruptedException {
        long lordStartTime = System.currentTimeMillis();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        CompletableFuture<Void> userCompletableFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            User user = new User("张三1", 10, 1);
            User save = userRepository.save(user);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("新增用户耗时:" + (endTime - lordStartTime) / 1000 + "秒");
        },scheduledExecutorService);

        CompletableFuture<Void> deptCompletableFuture = userCompletableFuture.thenRun(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Dept dept = new Dept("boss", "ceo", 0L);
            Dept save = deptRepository.save(dept);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("新增部门耗时:" + (endTime - lordStartTime) / 1000 + "秒");
        });
        deptCompletableFuture.get();

        CompletableFuture<Void> menuCompletableFuture = userCompletableFuture.thenRun(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Menu menu = new Menu("dept", "部门");
            Menu save = menuRepository.save(menu);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("新增菜单耗时:" + (endTime - lordStartTime) / 1000 + "秒");
        });
        menuCompletableFuture.get();

        log.info("总耗时:" + (System.currentTimeMillis() - lordStartTime) / 1000 + "秒");
    }

    @GetMapping("save/then/run3")
    // 执行第一个任务后 可以继续执行第二个任务 两个任务之间无传参 无返回值
    public void defaultThenRun3() throws ExecutionException, InterruptedException {
        long lordStartTime = System.currentTimeMillis();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        CompletableFuture<Void> userCompletableFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            User user = new User("张三1", 10, 1);
            User save = userRepository.save(user);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("新增用户耗时:" + (endTime - lordStartTime) / 1000 + "秒");
        },scheduledExecutorService);

        CompletableFuture<Void> deptCompletableFuture = userCompletableFuture.thenRunAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Dept dept = new Dept("boss", "ceo", 0L);
            Dept save = deptRepository.save(dept);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("新增部门耗时:" + (endTime - lordStartTime) / 1000 + "秒");
        });
        deptCompletableFuture.get();

        CompletableFuture<Void> menuCompletableFuture = userCompletableFuture.thenRunAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Menu menu = new Menu("dept", "部门");
            Menu save = menuRepository.save(menu);
            long endTime = System.currentTimeMillis();
            log.info("线程：{}，---{}",Thread.currentThread().getName(),Thread.currentThread().getId());
            log.info("新增菜单耗时:" + (endTime - lordStartTime) / 1000 + "秒");
        });
        menuCompletableFuture.get();

        log.info("总耗时:" + (System.currentTimeMillis() - lordStartTime) / 1000 + "秒");
    }

    @GetMapping("save/then/run4")
    // 执行第一个任务后 可以继续执行第二个任务 两个任务之间无传参 无返回值
    public void defaultThenRun4() throws ExecutionException, InterruptedException {
        long lordStartTime = System.currentTimeMillis();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        CompletableFuture<Void> userCompletableFuture = CompletableFuture.runAsync(() -> {
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
        },scheduledExecutorService);


        CompletableFuture<Void> deptCompletableFuture = userCompletableFuture.thenRunAsync(() -> {
            long startTime = System.currentTimeMillis();
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
        deptCompletableFuture.get();

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
        menuCompletableFuture.get();
        log.info("总耗时:" + (System.currentTimeMillis() - lordStartTime) / 1000 + "秒");
    }

    @GetMapping("save/then/run5")
    // 执行第一个任务后 可以继续执行第二个任务 两个任务之间无传参 无返回值
    public void defaultThenRun5() throws ExecutionException, InterruptedException {
        long lordStartTime = System.currentTimeMillis();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        CompletableFuture<Void> userCompletableFuture = CompletableFuture.runAsync(() -> {
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
        },scheduledExecutorService);


        CompletableFuture<Void> deptCompletableFuture = userCompletableFuture.thenRunAsync(() -> {
            long startTime = System.currentTimeMillis();
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
        deptCompletableFuture.get();

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
        },scheduledExecutorService);
        menuCompletableFuture.get();
        log.info("总耗时:" + (System.currentTimeMillis() - lordStartTime) / 1000 + "秒");
    }
}

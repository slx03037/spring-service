package com.xinwen.completable.future.controller;


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
 * @date 2024/5/17 15:20
 */
@RestController
@Slf4j
@RequestMapping("test")
public class TestController {

    @Resource
    private UserRepository userRepository;

    @Resource
    private MenuRepository menuRepository;

    @Resource
    private DeptRepository deptRepository;

    @GetMapping("insert")
    public String insert() throws InterruptedException {
        long timeMillis = System.currentTimeMillis();
        User user = new User("张三", 10, 1);
        Menu menu = new Menu("user", "人员");
        Dept dept = new Dept("boss", "ceo", 0L);
        //Thread.sleep(500);
        userRepository.save(user);
        log.info("新增用户耗时:{}毫秒", System.currentTimeMillis() - timeMillis);
        //Thread.sleep(200);
        menuRepository.save(menu);
        log.info("新增菜单耗时:{}毫秒", System.currentTimeMillis() - timeMillis);
        //Thread.sleep(200);
        deptRepository.save(dept);
        log.info("新增部门耗时:{}毫秒", System.currentTimeMillis() - timeMillis);
        String s = String.format("耗时:%s", System.currentTimeMillis() - timeMillis);
        return s;
    }

    /**
     * Future是什么?
     *
     * Java 1.5中引入Callable解决多线程执行无返回值的问题。
     * Future是为了配合Callable/Runnable而产生的。简单来讲，我们可以通过future来对任务查询、取消、执行结果的获取，是调用方与异步执行方之间沟通的桥梁。
     * FutureTask实现了RunnableFuture接口，同时具有Runnable、Future的能力，即既可以作为Future得到Callable的返回值，又可以作为一个Runnable。
     * CompletableFuture实现了Futrue接口。
     * Future是Java5新加的一个接口，它提供了一种异步并行计算的功能。如果主线程需要执行一个很耗时的计算任务，我们可以将这个任务通过Future放到异步线程中去执行。主线程继续处理其他任务，处理完成后，再通过Future获取计算结果。
     * Future可以在连续流程中满足数据驱动的并发需求，既获得了并发执行的性能提升，又不失连续流程的简洁优雅。
     */

    @GetMapping("/save")
    public String save() {
        long startTime = System.currentTimeMillis();
        log.info("新增用户!");
        CompletableFuture<String> roleFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            User user = new User("张三1", 10, 1);
            userRepository.save(user);
            long endTime = System.currentTimeMillis();
            log.info("新增用户耗时:" + (endTime - startTime) + "毫秒");
            return String.format("新增用户耗时:%s", (endTime - startTime));
        });

        log.info("开始新增部门！");
        CompletableFuture<String> menuFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            Dept dept = new Dept("boss", "ceo", 0L);
            deptRepository.save(dept);
            long endTime = System.currentTimeMillis();
            log.info("新增部门耗时:" + (endTime - startTime) + "毫秒");
            return String.format("新增部门耗时:%s", (endTime - startTime));
        });

        log.info("开始新增菜单！");
        CompletableFuture<String> integralFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            Menu menu = new Menu("dept", "部门");
            menuRepository.save(menu);
            long endTime = System.currentTimeMillis();
            log.info("新增菜单耗时:" + (endTime - startTime) + "毫秒");
            return String.format("新增菜单耗时:%s", (endTime - startTime));
        });

        roleFuture.join();
        menuFuture.join();
        integralFuture.join();
        log.info("查询用户全部信息总耗时：" + (System.currentTimeMillis() - startTime));
        String s = String.format("耗时:%s", System.currentTimeMillis() - startTime);
        return s;
    }

    @GetMapping("/add/callable")
    public String callable() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
//        User user = new User("张三", 10, 1);
//        Menu menu = new Menu("user", "人员");
//        Dept dept = new Dept("boss", "ceo", 0L);
        Callable<User> userCall = new Callable<User>() {
            @Override
            public User call() throws Exception {
                long startTime = System.currentTimeMillis();
                //Thread.sleep(500);
                User user = new User("张三1", 10, 1);
                User save = userRepository.save(user);
                long endTime = System.currentTimeMillis();
                log.info("新增用户耗时:" + (endTime - startTime));
                return save;
            }
        };

        FutureTask<User> futureTask = new FutureTask<>(userCall);
        new Thread(futureTask).start();

        Callable<Dept> deptCall = new Callable<Dept>() {
            @Override
            public Dept call() throws Exception {
                long startTime = System.currentTimeMillis();
                //Thread.sleep(200);
                Dept dept = new Dept("boss", "ceo", 0L);
                Dept save = deptRepository.save(dept);
                long endTime = System.currentTimeMillis();
                log.info("新增部门耗时:" + (endTime - startTime));
                return save;
            }
        };

        FutureTask<Dept> deptFuture = new FutureTask<>(deptCall);
        new Thread(deptFuture).start();

        Callable<Menu> callable = new Callable<Menu>() {

            @Override
            public Menu call() throws Exception {
                long startTime = System.currentTimeMillis();
               // Thread.sleep(200);
                Menu menu = new Menu("dept", "部门");
                Menu save = menuRepository.save(menu);
                long endTime = System.currentTimeMillis();
                log.info("新增菜单耗时:" + (endTime - startTime) );
                return save;
            }
        };

        FutureTask<Menu> menuFutureTask=new FutureTask<>(callable);
        new Thread(menuFutureTask).start();

        log.info("新增用户结果：" + futureTask.get());
        log.info("新增部门结果：" + deptFuture.get());
        log.info("新增菜单结果：" + menuFutureTask.get());

        long endTime = System.currentTimeMillis();
        log.info("总耗时:" + (endTime - startTime));
        return String.valueOf(endTime - startTime);
    }

    @GetMapping("/add/callable/block")
    public String callableBlock() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
//        User user = new User("张三", 10, 1);
//        Menu menu = new Menu("user", "人员");
//        Dept dept = new Dept("boss", "ceo", 0L);
        Callable<User> userCall = new Callable<User>() {
            @Override
            public User call() throws Exception {
                long startTime = System.currentTimeMillis();
                //Thread.sleep(500);
                User user = new User("张三1", 10, 1);
                User save = userRepository.save(user);
                long endTime = System.currentTimeMillis();
                log.info("新增用户耗时:" + (endTime - startTime));
                return save;
            }
        };
        /**
         * Future对于结果的获取，不是很友好，只能通过阻塞或者轮询的方式得到任务的结果。Future.get() 就是阻塞调用，
         * 在线程获取结果之前get方法会一直阻塞；Future提供了一个isDone方法，可以在程序中轮询这个方法查询执行结果。
         */
        FutureTask<User> futureTask = new FutureTask<>(userCall);
        new Thread(futureTask).start();

        /**
         * 这里的 futureTask.get()如果放到如下图所示的位置，则futureTask下面的线程将futureTask.get()
         * 完成后才能执行，没有执行完，则一直阻塞。
         */

        /**
         * 当futureTask.get()放在此位置时，get()未获取到结果则会一直阻塞在这里，其他线程无法执行
         */
        log.info("新增用户结果：" + futureTask.get());

        Callable<Dept> deptCall = new Callable<Dept>() {
            @Override
            public Dept call() throws Exception {
                long startTime = System.currentTimeMillis();
                //Thread.sleep(200);
                Dept dept = new Dept("boss", "ceo", 0L);
                Dept save = deptRepository.save(dept);
                long endTime = System.currentTimeMillis();
                log.info("新增部门耗时:" + (endTime - startTime));
                return save;
            }
        };

        FutureTask<Dept> deptFuture = new FutureTask<>(deptCall);
        new Thread(deptFuture).start();
        log.info("新增部门结果：" + deptFuture.get());

        Callable<Menu> callable = new Callable<Menu>() {

            @Override
            public Menu call() throws Exception {
                long startTime = System.currentTimeMillis();
                // Thread.sleep(200);
                Menu menu = new Menu("dept", "部门");
                Menu save = menuRepository.save(menu);
                long endTime = System.currentTimeMillis();
                log.info("新增菜单耗时:" + (endTime - startTime) );
                return save;
            }
        };

        FutureTask<Menu> menuFutureTask=new FutureTask<>(callable);
        new Thread(menuFutureTask).start();

        log.info("新增菜单结果：" + menuFutureTask.get());

        long endTime = System.currentTimeMillis();
        log.info("总耗时:" + (endTime - startTime));
        return String.valueOf(endTime - startTime);
    }

    @GetMapping("/add/executor")
    public String executor() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<User> userCall = new Callable<User>() {
            @Override
            public User call() throws Exception {
                long startTime = System.currentTimeMillis();
                //Thread.sleep(500);
                User user = new User("张三1", 10, 1);
                User save = userRepository.save(user);
                long endTime = System.currentTimeMillis();
                log.info("新增用户耗时:" + (endTime - startTime));
                return save;
            }
        };

        Callable<Dept> deptCall = new Callable<Dept>() {
            @Override
            public Dept call() throws Exception {
                long startTime = System.currentTimeMillis();
                //Thread.sleep(200);
                Dept dept = new Dept("boss", "ceo", 0L);
                Dept save = deptRepository.save(dept);
                long endTime = System.currentTimeMillis();
                log.info("新增部门耗时:" + (endTime - startTime));
                return save;
            }
        };

        Callable<Menu> callable = new Callable<Menu>() {

            @Override
            public Menu call() throws Exception {
                long startTime = System.currentTimeMillis();
                //Thread.sleep(200);
                Menu menu = new Menu("dept", "部门");
                Menu save = menuRepository.save(menu);
                long endTime = System.currentTimeMillis();
                log.info("新增菜单耗时:" + (endTime - startTime) );
                return save;
            }
        };
        Future userFuture = executor.submit(userCall);
        Future deptFuture = executor.submit(deptCall);
        Future menuFuture = executor.submit(callable);

        log.info("用户新增结果为：" + userFuture.get());
        log.info("部门新增结果为：" + deptFuture.get());
        log.info("菜单新增结果为：" + menuFuture.get());

        long endTime = System.currentTimeMillis();
        log.info("总耗时:" + (endTime - startTime));
        return String.valueOf(endTime-startTime);
    }

    @GetMapping("/add/executor1")
    public String executor1() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<User> userCall = new Callable<User>() {
            @Override
            public User call() throws Exception {
                long startTime = System.currentTimeMillis();
                //Thread.sleep(500);
                User user = new User("张三1", 10, 1);
                User save = userRepository.save(user);
                long endTime = System.currentTimeMillis();
                log.info("新增用户耗时:{},线程名称:{}-----{}", (endTime - startTime),Thread.currentThread().getName(),Thread.currentThread().getId());
                return save;
            }
        };
        Future userFuture = executor.submit(userCall);
        log.info("用户新增结果为：{},线程名称:{}-----{}" ,userFuture.get(),Thread.currentThread().getName(),Thread.currentThread().getId());

        Callable<Dept> deptCall = new Callable<Dept>() {
            @Override
            public Dept call() throws Exception {
                long startTime = System.currentTimeMillis();
                //Thread.sleep(200);
                Dept dept = new Dept("boss", "ceo", 0L);
                Dept save = deptRepository.save(dept);
                long endTime = System.currentTimeMillis();
                log.info("新增部门耗时:{},线程名称:{},----{}", (endTime - startTime),Thread.currentThread().getName(),Thread.currentThread().getId());
                return save;
            }
        };
        Future deptFuture = executor.submit(deptCall);
        log.info("部门新增结果为：{},线程名称:{}-----{}" , deptFuture.get(),Thread.currentThread().getName(),Thread.currentThread().getId());

        Callable<Menu> callable = new Callable<Menu>() {

            @Override
            public Menu call() throws Exception {
                long startTime = System.currentTimeMillis();
                //Thread.sleep(200);
                Menu menu = new Menu("dept", "部门");
                Menu save = menuRepository.save(menu);
                long endTime = System.currentTimeMillis();
                log.info("新增菜单耗时:{},线程名称:{}-----{}" ,(endTime - startTime) ,Thread.currentThread().getName(),Thread.currentThread().getId());
                return save;
            }
        };

        Future menuFuture = executor.submit(callable);
        log.info("菜单新增结果为：{},线程名称:{},--------{}" , menuFuture.get(),Thread.currentThread().getName(),Thread.currentThread().getId());

        long endTime = System.currentTimeMillis();
        log.info("总耗时:" + (endTime - startTime));
        return String.valueOf(endTime-startTime);
    }
}

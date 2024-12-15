package com.xinwen.completable.future.controller.and.acceptboth;

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

/**
 * @author shenlx
 * @description
 * @date 2024/5/20 16:55
 */
@RestController
@Slf4j
@RequestMapping("test")
public class TestThenAcceptBothController {
    @Resource
    private UserRepository userRepository;

    @Resource
    private MenuRepository menuRepository;

    @Resource
    private DeptRepository deptRepository;

    @GetMapping("/save/then/accept/both")
    //将两个任务的执行结果作为方法入参，传递到指定方法中，且无返回值。
    public void defaultThenAcceptBoth(){
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
            log.info("线程：{}，---{}", Thread.currentThread().getName(), Thread.currentThread().getId());
            log.info("内部新增用户耗时:" + (endTime - startTime) / 1000 + "秒");
            log.info("新增用户耗时:" + (endTime - lordStartTime) / 1000 + "秒");
            return save;
        });

        CompletableFuture<Void> voidCompletableFuture = userCompletableFuture.thenAcceptBoth(CompletableFuture.supplyAsync( () -> {
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
                }), (user, dept) -> {
                    log.info("打印user:{}", user);
                    log.info("打印dept:{}", dept);
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
                });
        log.info("总耗时:" + (System.currentTimeMillis() - lordStartTime) / 1000 + "秒");
    }


}

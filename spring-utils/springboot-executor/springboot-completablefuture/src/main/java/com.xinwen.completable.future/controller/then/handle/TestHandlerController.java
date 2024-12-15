package com.xinwen.completable.future.controller.then.handle;

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
 * @date 2024/5/20 15:12
 */
@RestController
@Slf4j
@RequestMapping("test")
public class TestHandlerController {
    @Resource
    private UserRepository userRepository;

    @Resource
    private MenuRepository menuRepository;

    @Resource
    private DeptRepository deptRepository;

    @GetMapping("save/handle")
    //    某个任务执行完成后，执行的回调方法，有返回值；并且handle方法返回的CompletableFuture的result是第二个任务的结果。
    public void handle() {
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
        CompletableFuture<Dept> stringCompletableFuture1 = completableFuture.handle((a, throwable) -> {
            log.info("用户信息:{}", a);
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

        CompletableFuture<Menu> menuCompletableFuture= completableFuture.handle((user, throwable) -> {
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
        log.info("输出结果为第二个任务：" + stringCompletableFuture1.join());
        log.info("输出结果为第二个任务：" + menuCompletableFuture.join());
        log.info("总耗时:" + (System.currentTimeMillis() - lordStartTime) / 1000 + "秒");
    }
}

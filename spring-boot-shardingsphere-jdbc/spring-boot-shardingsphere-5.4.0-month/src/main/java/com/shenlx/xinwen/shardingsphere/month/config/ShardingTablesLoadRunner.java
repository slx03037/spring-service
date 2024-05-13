//package com.shenlx.xinwen.shardingsphere.month.config;
//
//import com.shenlx.xinwen.shardingsphere.month.mapper.OrderMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.time.LocalDateTime;
//
///**
// * @author shenlx
// * @description
// * @date 2024/5/13 18:14
// */
//@Slf4j
//@Order(value = 1) // 数字越小，越先执行
//@Component
//public class ShardingTablesLoadRunner implements CommandLineRunner {
//
//    @Resource
//    private OrderMapper orderMapper;
//    @Override
//    public void run(String... args) {
//        // 读取已有分表，进行缓存
//        orderMapper.queryMaxCode();
//
//        log.info(">>>>>>>>>> 【ShardingTablesLoadRunner】缓存已有分表成功 <<<<<<<<<<");
//    }
//}

package com.shenlx.xinwen.shardingsphere.cutom.key.generator.controller;

import com.shenlx.xinwen.shardingsphere.cutom.key.generator.entity.Order;
import com.shenlx.xinwen.shardingsphere.cutom.key.generator.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author shenlx
 * @description
 * @date 2024/5/7 16:15
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @PostMapping("/order/add")
    private Object add(@RequestBody Order order){
        orderService.add(order);
        return new HashMap<String,Integer>().put("code",200);
    }

    @GetMapping("/order/listPage")
    private Object listPage(){
        return orderService.listPage();
    }
}

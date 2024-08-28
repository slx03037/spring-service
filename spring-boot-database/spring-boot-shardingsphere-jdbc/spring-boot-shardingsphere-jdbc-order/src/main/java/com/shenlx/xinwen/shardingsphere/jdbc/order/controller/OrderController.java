package com.shenlx.xinwen.shardingsphere.jdbc.order.controller;

import com.shenlx.xinwen.shardingsphere.jdbc.order.entity.Order;
import com.shenlx.xinwen.shardingsphere.jdbc.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author shenlx
 * @description
 * @date 2024/5/7 11:41
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
}

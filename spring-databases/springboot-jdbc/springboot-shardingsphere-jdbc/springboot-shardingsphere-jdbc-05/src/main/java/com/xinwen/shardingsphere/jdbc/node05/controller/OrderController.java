package com.xinwen.shardingsphere.jdbc.node05.controller;


import com.xinwen.shardingsphere.jdbc.node05.entity.Order;
import com.xinwen.shardingsphere.jdbc.node05.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

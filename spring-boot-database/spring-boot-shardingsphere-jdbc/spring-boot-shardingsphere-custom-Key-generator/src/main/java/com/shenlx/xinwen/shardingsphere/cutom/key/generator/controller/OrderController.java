package com.shenlx.xinwen.shardingsphere.cutom.key.generator.controller;

import com.shenlx.xinwen.shardingsphere.cutom.key.generator.entity.Order;
import com.shenlx.xinwen.shardingsphere.cutom.key.generator.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "操作成功");
        return map;
    }

    @GetMapping("/order/listPage")
    private Object listPage(@RequestParam("type")Integer type){
        return orderService.listPage(type);
    }
}
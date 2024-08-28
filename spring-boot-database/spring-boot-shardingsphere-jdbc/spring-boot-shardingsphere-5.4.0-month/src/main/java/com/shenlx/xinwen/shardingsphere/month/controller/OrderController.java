package com.shenlx.xinwen.shardingsphere.month.controller;

import com.shenlx.xinwen.shardingsphere.month.entity.Order;
import com.shenlx.xinwen.shardingsphere.month.entity.OrderBO;
import com.shenlx.xinwen.shardingsphere.month.service.OrderService;
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
    private Object add(@RequestBody OrderBO order){
        orderService.add(order);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "操作成功");
        return map;
    }

    @GetMapping("/order/listPage")
    private Object listPage(@RequestParam(value = "type",required = false)Integer type
            ,@RequestParam(value = "startTime",required = false)String startTime
            ,@RequestParam(value = "endTime",required = false)String endTime){
        return orderService.listPage(type,startTime,endTime);
    }
}

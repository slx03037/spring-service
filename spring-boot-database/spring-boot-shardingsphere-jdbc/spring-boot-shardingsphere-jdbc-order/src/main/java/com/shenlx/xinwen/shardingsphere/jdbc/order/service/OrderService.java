package com.shenlx.xinwen.shardingsphere.jdbc.order.service;

import com.shenlx.xinwen.shardingsphere.jdbc.order.entity.Order;
import com.shenlx.xinwen.shardingsphere.jdbc.order.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shenlx
 * @description
 * @date 2024/5/7 11:42
 */
@Service
public class OrderService {
    @Resource
    private OrderMapper orderMapper;

    public void add(Order order){
        orderMapper.insert(order);
    }

}

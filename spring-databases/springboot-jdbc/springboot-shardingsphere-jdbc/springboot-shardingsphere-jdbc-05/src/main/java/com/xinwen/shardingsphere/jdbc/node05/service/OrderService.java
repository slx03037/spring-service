package com.xinwen.shardingsphere.jdbc.node05.service;


import com.xinwen.shardingsphere.jdbc.node05.entity.Order;
import com.xinwen.shardingsphere.jdbc.node05.mapper.OrderMapper;
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

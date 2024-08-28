package com.shenlx.xinwen.shardingsphere.jdbc.order.mapper;

import com.shenlx.xinwen.shardingsphere.jdbc.order.entity.Order;

/**
 * @author shenlx
 * @description
 * @date 2024/5/7 10:31
 */
//@Mapper
public interface OrderMapper {
    int insert(Order order);
}

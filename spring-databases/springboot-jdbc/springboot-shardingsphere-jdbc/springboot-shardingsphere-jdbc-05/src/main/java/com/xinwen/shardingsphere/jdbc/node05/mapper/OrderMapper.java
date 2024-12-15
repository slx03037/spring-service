package com.xinwen.shardingsphere.jdbc.node05.mapper;


import com.xinwen.shardingsphere.jdbc.node05.entity.Order;

/**
 * @author shenlx
 * @description
 * @date 2024/5/7 10:31
 */
//@Mapper
public interface OrderMapper {
    int insert(Order order);
}

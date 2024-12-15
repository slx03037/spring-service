package com.xinwen.shardingsphere.jdbc.node04.mapper;


import com.xinwen.shardingsphere.jdbc.node04.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shenlx
 * @description
 * @date 2024/5/7 16:15
 */
public interface OrderMapper {
    Long queryMaxCode();

    int insert(Order order);

    List<Order> listPage(@Param("offset")Integer offset
            ,@Param("pageSize")Integer pageSize
            ,@Param("type")Integer type);
}

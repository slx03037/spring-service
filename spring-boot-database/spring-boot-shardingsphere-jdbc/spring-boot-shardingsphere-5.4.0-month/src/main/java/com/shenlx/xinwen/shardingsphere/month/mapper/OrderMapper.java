package com.shenlx.xinwen.shardingsphere.month.mapper;

import com.shenlx.xinwen.shardingsphere.month.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author shenlx
 * @description
 * @date 2024/5/7 16:15
 */
public interface OrderMapper {
    Long queryMaxCode();

    Long queryMaxId(LocalDateTime now );

    int insert(Order order);

    List<Order> listPage(@Param("offset")Integer offset
            ,@Param("pageSize")Integer pageSize
            ,@Param("type")Integer type
            ,@Param("startTime")LocalDateTime startTime
            ,@Param("endTime")LocalDateTime endTime);
}

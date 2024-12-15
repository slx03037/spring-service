package com.xinwen.shardingsphere.jdbc.node02.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shenlx
 * @description
 * @date 2024/5/13 17:50
 */
@Data
public class OrderBO implements Serializable {
    private static final long serialVersionUID = 122202297332658130L;
    private Long orderId;

    private Integer orderType;

    private String orderName;

    private Integer status;

    private String createTime;
}

package com.shenlx.xinwen.shardingsphere.jdbc.order.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shenlx
 * @description
 * @date 2024/5/7 11:44
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = -4279716612726813353L;

    private Integer orderType;

    private String orderName;

    private Integer status;
}

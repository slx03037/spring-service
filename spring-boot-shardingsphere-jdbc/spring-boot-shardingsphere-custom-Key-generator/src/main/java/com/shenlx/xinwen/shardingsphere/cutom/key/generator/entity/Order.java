package com.shenlx.xinwen.shardingsphere.cutom.key.generator.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shenlx
 * @description
 * @date 2024/5/7 16:39
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = -4336402305002331953L;

    private Long orderId;

    private Integer orderType;

    private String orderName;

    private Integer status;
}

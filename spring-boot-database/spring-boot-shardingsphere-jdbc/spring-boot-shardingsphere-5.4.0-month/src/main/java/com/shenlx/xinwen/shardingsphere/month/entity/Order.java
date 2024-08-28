package com.shenlx.xinwen.shardingsphere.month.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

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

    private LocalDateTime createTime;
}

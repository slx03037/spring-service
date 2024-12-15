package com.xinwen.postgresql.node01.core.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shenlx
 * @description
 * @date 2024/9/12 10:59
 */
@Data
public class TheftRobbery implements Serializable {
    private static final long serialVersionUID = -2831379179424465450L;

    private Integer mdId;

    private String wpgg;

    private String wpzt;

}

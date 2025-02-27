package com.xinwen.mybatis.node01.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-10 14:54
 **/
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 8694567326989682394L;
    private String sno;
    private String name;
    private String sex;
}

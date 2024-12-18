package com.xinwen.ehcache.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-13 20:56
 **/
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -703986505323109557L;
    private String sno;
    private String name;
    private String sex;
}

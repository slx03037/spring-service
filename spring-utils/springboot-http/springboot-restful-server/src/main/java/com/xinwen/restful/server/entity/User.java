package com.xinwen.restful.server.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-02-10 13:07
 **/
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 8784786156844071454L;
    private String name;
    private Integer age;
    private byte sex;

}

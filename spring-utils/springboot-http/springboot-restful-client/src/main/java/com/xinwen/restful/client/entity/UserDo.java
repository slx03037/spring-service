package com.xinwen.restful.client.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-02-10 13:01
 **/
@Data
public class UserDo implements Serializable {
    private static final long serialVersionUID = -2960484696601764930L;

    private String name;
    private Integer age;
    private byte sex;

}

package com.xinwen.jdbc.template.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-10 15:54
 **/
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = 3178835120574253749L;
    private String sno;
    private String name;
    private String sex;
    private String dataSource;
}

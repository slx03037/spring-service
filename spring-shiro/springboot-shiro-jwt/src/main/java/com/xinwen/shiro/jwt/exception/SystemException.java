package com.xinwen.shiro.jwt.exception;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-05-04 10:25
 **/

public class SystemException extends Exception{
    private static final long serialVersionUID = -4924063682593924605L;
    public SystemException(String message){
        super(message);
    }
}

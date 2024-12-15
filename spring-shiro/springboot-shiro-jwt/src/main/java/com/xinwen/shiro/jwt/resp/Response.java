package com.xinwen.shiro.jwt.resp;

import java.util.HashMap;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-05-04 10:28
 **/

public class Response extends HashMap<String, Object> {
    private static final long serialVersionUID = 3760189749038411946L;

    public Response message(String message) {
        this.put("message", message);
        return this;
    }

    public Response data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public Response put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}

package com.xinwen.websocket.node02.model;

import lombok.Data;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-02-02 20:57
 **/
@Data
public class WsResponse<T> {
    private T result;
}

package com.xinwen.websocket.node02.model;

import lombok.Data;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-02-02 20:56
 **/
@Data
public class ResponseMessage {
    public ResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    private String responseMessage;
}

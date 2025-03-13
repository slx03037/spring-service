package com.xinwen.jgrapht.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author shenlx
 * @description 自定义异常类，用于处理无效请求的情况。
 * @date 2025/3/13 11:00
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){super(message);}
}

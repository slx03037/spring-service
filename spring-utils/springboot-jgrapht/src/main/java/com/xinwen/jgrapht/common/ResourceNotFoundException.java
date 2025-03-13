package com.xinwen.jgrapht.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author shenlx
 * @description 自定义异常类，用于处理资源未找到的情况
 * @date 2025/3/13 11:01
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}

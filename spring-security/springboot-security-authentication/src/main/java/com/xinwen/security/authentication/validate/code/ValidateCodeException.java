package com.xinwen.security.authentication.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-04-27 17:12
 **/

public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ValidateCodeException(String msg) {
        super(msg);
    }
}

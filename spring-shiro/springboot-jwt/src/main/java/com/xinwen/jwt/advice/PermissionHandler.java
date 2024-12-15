package com.xinwen.jwt.advice;

import com.xinwen.jwt.model.Result;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author shenlx
 * @description
 * @date 2024/12/13 14:47
 */
@RestControllerAdvice
public class PermissionHandler {
    @ExceptionHandler(value = { SignatureException.class })
    @ResponseBody
    public Result<?> authorizationException(SignatureException e){
        return Result.error(e.getMessage());
    }
}

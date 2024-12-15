package com.xinwen.security.authentication.validate.sms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-04-27 17:18
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmsCode implements Serializable {
    private static final long serialVersionUID = 5167923646849634139L;
    private String code;

    private LocalDateTime expireTime;
    boolean isExpire() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public SmsCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

}

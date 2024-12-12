package com.xinwen.alipay.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author shenlx
 * @description
 * @date 2024/11/4 16:12
 */

@Data
@Component
@ConfigurationProperties(prefix="alipay")
public class AliPayConfig {
    private String appId;

    private String appPrivateKey;

    private String alipayPublicKey;

    private String notifyUrl;
}

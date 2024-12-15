package com.xinwen.restful.server.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-02-10 16:51
 **/
@ConfigurationProperties(prefix = "system.code")
@Component
@Data
public class PushApplicationContext {
    private String authCenter;
    private String  biPlatform;
}

package com.xinwen.interceptor.config;

import com.xinwen.interceptor.interceptor.TimeInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-14 15:22
 **/
@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //不拦截的uri
        final String[] commonExclude = {"/error", "/files/**"};
        registry.addInterceptor(timeInterceptor).excludePathPatterns(commonExclude);
        //registry.addInterceptor(timeInterceptor);
    }
}

package com.xinwen.example.config.filter.handler;

import com.xinwen.example.config.filter.OnceRequestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shenlx
 * @description 过滤器配置类
 * @date 2024/5/21 22:54
 */
@Configuration
public class FilterConfig {
    @Bean
    public OnceRequestFilter requestFilter(){
        return new OnceRequestFilter();
    }
    @Bean
    public FilterRegistrationBean<OnceRequestFilter> registrationBean() {
        FilterRegistrationBean<OnceRequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(requestFilter());
        registrationBean.addUrlPatterns("/filter/*");
        registrationBean.setName("RequestFilter");
        //过滤器的级别，值越小级别越高越先执行
        registrationBean.setOrder(1);
        return registrationBean;
    }
}

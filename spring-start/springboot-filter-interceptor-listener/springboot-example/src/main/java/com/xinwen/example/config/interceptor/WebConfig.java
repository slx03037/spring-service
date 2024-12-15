package com.xinwen.example.config.interceptor;

import com.xinwen.example.config.filter.TimeFilter;
import com.xinwen.example.config.interceptor.handler.TimeInterceptor;
import com.xinwen.example.config.interceptor.handler.PageInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

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

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(timeInterceptor);
//    }

    @Bean
    public FilterRegistrationBean timeFilter() {
        log.info("FilterRegistrationBean:进入timeFilter()");
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        filterRegistrationBean.setFilter(timeFilter);

        List<String> urlList = new ArrayList<>();
        urlList.add("/*");
        filterRegistrationBean.setUrlPatterns(urlList);
        return filterRegistrationBean;
    }

    /*
     * 拦截器依赖于Spring容器，此处拦截了所有，需要对静态资源进行放行
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截器默认的执行顺序，就是它的注册顺序，也可以通过Order手动设置控制，值越小越先执行。
//        registry.addInterceptor(new PageInterceptor()).addPathPatterns("/**").order()
        registry.addInterceptor(timeInterceptor);
        registry.addInterceptor(new PageInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/page/login", "/user/login","/page/ajax","/static/**");
    }


    /*
     * 不要要写控制器即可完成页面跳转访问
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/page/ajax").setViewName("ajax");
    }


    /*
     * 自定义静态资源映射
        Spring Boot 默认为我们提供了静态资源映射：
                classpath:/META-INF/resources
                classpath:/resources
                classpath:/static
                classpath:/public
              优先级：META-INF/resources > resources > static > public
     * @param registry
     *
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/static/**").addResourceLocations("file:E:/static/");
    }
}

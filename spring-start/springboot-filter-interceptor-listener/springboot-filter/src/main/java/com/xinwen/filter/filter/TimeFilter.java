package com.xinwen.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-14 15:14
 **/
@Slf4j
@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("开始执行过滤器");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("开始执行过滤器");
        Long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("【过滤器】耗时 " + (System.currentTimeMillis() - start));
        System.out.println("结束执行过滤器");
    }

    @Override
    public void destroy() {

    }




}

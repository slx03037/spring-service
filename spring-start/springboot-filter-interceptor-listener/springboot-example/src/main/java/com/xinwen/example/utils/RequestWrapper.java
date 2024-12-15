package com.xinwen.example.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author shenlx
 * @description 在请求到达之前对 request 进行修改
 * @date 2024/5/21 22:49
 */
@Slf4j
public class RequestWrapper extends HttpServletRequestWrapper {
    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public RequestWrapper(HttpServletRequest request) {
        super(request);
        log.info("RequestWrapper");
    }

    @Override
    public String getParameter(String name) {
        // 可以对请求参数进行过滤
        return super.getParameter(name);
    }

    @Override
    public String[] getParameterValues(String name) {
        // 对请求参数值进行过滤
//        String[] values =super.getRequest().getParameterValues(name);
//        return super.getParameterValues(name);
        return "t e s t".split(" ");
    }
}

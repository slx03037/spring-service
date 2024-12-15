package com.xinwen.example.config.interceptor.handler;

import com.xinwen.example.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shenlx
 * @description 登录拦截
 * @date 2024/5/21 22:56
 */
@Component
public class PageInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User)request.getSession().getAttribute("user");
        if (!ObjectUtils.isEmpty(user)) {
            return true;
        } else {
            // 不管是转发还是重定向，必须返回false。否则出现多次提交响应的错误
            redirect(request, response);
            return false;
        }
    }

    /*
     * 对于请求是ajax请求重定向问题的处理方法
     * @param request
     * @param response
     *
     */
    public void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){// ajax
            //获取当前请求的路径
            response.setHeader("Access-Control-Expose-Headers", "REDIRECT,CONTENT_PATH");
            //告诉ajax我是重定向
            response.setHeader("REDIRECT", "REDIRECT");
            //告诉ajax我重定向的路径
            StringBuffer url = request.getRequestURL();// "/"
            String contextPath = request.getContextPath();// ""
            // 这里的值是 / ，前端页面根据 / 路径进行跳转，
            // 会再次发出请求，进去拦截器判断，发现没有用户信息，然后重定向到 /page/login
            // 这里的目的就是 跳到登录页面吗？
            String contentPath = url.replace(url.indexOf(contextPath) + contextPath.length(), url.length(), "/").toString();// "/"
            response.setHeader("CONTENT_PATH", contentPath);
        }else{// http
            response.sendRedirect( "/page/login");
        }

        response.getWriter().write(403);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }
}

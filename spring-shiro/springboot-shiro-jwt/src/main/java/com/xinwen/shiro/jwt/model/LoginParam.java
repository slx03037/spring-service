package com.xinwen.shiro.jwt.model;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description: 登录认证接口参数
 * @author: shenlx
 * @create: 2023-05-08 14:33
 **/

public class LoginParam {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
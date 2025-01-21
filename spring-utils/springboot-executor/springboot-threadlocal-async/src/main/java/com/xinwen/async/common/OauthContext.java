package com.xinwen.async.common;

/**
 * @author shenlx
 * @description 用户上下文信息
 * @date 2025/2/12 11:59
 */
public class OauthContext {

    private static final ThreadLocal<LoginVal> loginValThreadLocal=new ThreadLocal<>();

    public static LoginVal get(){
        return loginValThreadLocal.get();
    }

    public static void set(LoginVal loginVal){
        loginValThreadLocal.set(loginVal);
    }

    public static void clear(){
        loginValThreadLocal.remove();
    }
}

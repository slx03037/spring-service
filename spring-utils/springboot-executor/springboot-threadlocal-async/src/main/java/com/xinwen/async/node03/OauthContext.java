package com.xinwen.async.node03;

import com.xinwen.async.common.LoginVal;

/**
 * @author shenlx
 * @description
 * @date 2025/2/13 15:17
 */
public class OauthContext {
    /**
     * 这种方案不建议使用，InheritableThreadLocal虽然能够实现父子线程间的复用，但是在线程池中使用会存在复用的问题
     */
    private static final InheritableThreadLocal<LoginVal> l=new InheritableThreadLocal<>();

    public static LoginVal get(){
        return l.get();
    }

    public static void set(LoginVal loginVal){
        l.set(loginVal);
    }

    public static void clear(){
        l.remove();
    }
}

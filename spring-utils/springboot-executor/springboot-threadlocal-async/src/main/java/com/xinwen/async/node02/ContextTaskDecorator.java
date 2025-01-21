package com.xinwen.async.node02;

import com.xinwen.async.common.LoginVal;
import com.xinwen.async.common.OauthContext;
import org.springframework.core.task.TaskDecorator;

/**
 * @author shenlx
 * @description 上下文装饰器
 * @date 2025/2/12 13:47
 */
public class ContextTaskDecorator implements TaskDecorator {
    /**
     * 线程池设置TaskDecorator
     * 这是一个执行回调方法的装饰器，主要应用于传递上下文，或者提供任务的监控/统计信息。
     */
    @Override
    public Runnable decorate(Runnable runnable) {
        //获取父线程的LoginVal
        LoginVal loginVal = OauthContext.get();

        return ()->{
            try{
                //将主线程的信息，设置到子线程中
                OauthContext.set(loginVal);
                //执行子线程，这一步不能忘
                runnable.run();
            }finally {
                //线程结束，清空这些信息，否则可能造成内存泄露
                OauthContext.clear();
            }
        };
    }
}

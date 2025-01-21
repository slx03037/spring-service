package com.xinwen.async.node02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author shenlx
 * @description
 * @date 2025/2/12 13:53
 */
@Configuration
public class TaskConfigure {

    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);//核心线程数
        threadPoolTaskExecutor.setMaxPoolSize(50);//最大线程数
        threadPoolTaskExecutor.setKeepAliveSeconds(1000);//活跃时间
        threadPoolTaskExecutor.setQueueCapacity(200);
        threadPoolTaskExecutor.setTaskDecorator(new ContextTaskDecorator());//设置TaskDecorator，用于解决父子线程间的数据复用
        threadPoolTaskExecutor.setRejectedExecutionHandler(
                new ThreadPoolExecutor.CallerRunsPolicy());//设置策略
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);//等待所有任务结束后再关闭线程池

        return threadPoolTaskExecutor;
    }
}

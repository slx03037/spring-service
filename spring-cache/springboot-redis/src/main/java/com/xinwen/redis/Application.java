package com.xinwen.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author shenlx
 * @description
 * @date 2024/12/12 20:38
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.xinwen.redis.mapper"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


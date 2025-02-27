package com.xinwen.postgresql.node01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shenlx
 * @description
 * @date 2024/9/12 10:31
 */
@SpringBootApplication
@MapperScan("com.xinwen.postgresql.node01.core.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

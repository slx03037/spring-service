package com.xinwen.shardingsphere.jdbc.node01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 18:11
 */
@SpringBootApplication
@MapperScan(basePackages = "com.xinwen.shardingsphere.jdbc.node01.mapper")
public class Application {
    public static void main(String[]args){
        SpringApplication.run(Application.class,args);
    }
}

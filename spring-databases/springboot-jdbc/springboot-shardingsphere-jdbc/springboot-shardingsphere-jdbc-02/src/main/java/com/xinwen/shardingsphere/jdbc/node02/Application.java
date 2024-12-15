package com.xinwen.shardingsphere.jdbc.node02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shenlx
 * @description
 * @date 2024/5/11 11:20
 */
@SpringBootApplication
@MapperScan(basePackages = "com.xinwen.shardingsphere.jdbc.node02.mapper")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}

package com.xinwen.shardingsphere.jdbc.node04;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shenlx
 * @description
 * @date 2024/5/7 16:10
 */
@SpringBootApplication
@MapperScan(basePackages = "com.shenlx.xinwen.shardingsphere.cutom.key.generator.com.xinwen.mybatis.node01.mapper")
public class Application {
    public static void main(String[]args){
        SpringApplication.run(Application.class,args);
    }
}

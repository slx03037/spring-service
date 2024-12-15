package com.xinwen.generator.uid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 17:11
 */
@SpringBootApplication
@MapperScan(basePackages = "com.xinwen.generator.uid.mapper")
public class Application {
    public static void main(String[]args){
        SpringApplication.run(Application.class,args);
    }
}

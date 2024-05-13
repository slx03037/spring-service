package com.shenlx.xinwen.shardingsphere.month;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenlx
 * @description
 * @date 2024/5/11 11:20
 */
@SpringBootApplication
@MapperScan(basePackages = "com.shenlx.xinwen.shardingsphere.month.mapper")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}

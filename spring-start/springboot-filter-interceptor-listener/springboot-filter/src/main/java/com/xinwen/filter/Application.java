package com.xinwen.filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author shenlx
 * @description
 * @date 2024/12/13 10:29
 */
@SpringBootApplication
/**
 * 要想 @WebFilter 注解生效，需要在配置类上标注另外一个注解 @ServletComponentScan 用于扫描使其生效
 */
@ServletComponentScan(value = {"com.example.springbootintercept.filter"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

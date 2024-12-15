package com.xinwen.shardingsphere.jdbc.node05;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-06-27 14:25
 **/

@SpringBootApplication
@MapperScan(basePackages = "com.xinwen.shardingsphere.jdbc.node05.mapper")
public class Application {
    public static void main(String[]args){
        SpringApplication.run(Application.class,args);
    }
    public static void main1(String[]agrs){
        String s="";
        if (StringUtils.isNotEmpty(s) && !"0".equals(s)) {
            s="-".startsWith(s)?s.replace("-",""):"-"+s;
            System.out.println(s);
        }


    }
}

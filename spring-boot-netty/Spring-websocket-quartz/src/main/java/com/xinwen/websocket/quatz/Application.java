package com.xinwen.websocket.quatz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author shenlx
 * @description
 * @date 2024/9/16 10:58
 */
@SpringBootApplication
@EnableScheduling
public class Application  {
    public static void main(String[]args){
        SpringApplication.run(Application.class,args);
    }
}

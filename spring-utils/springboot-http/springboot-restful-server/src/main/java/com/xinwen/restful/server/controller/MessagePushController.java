package com.xinwen.restful.server.controller;


import com.xinwen.restful.server.service.MessageGetService;
import com.xinwen.restful.server.service.MessagePostService;
import com.xinwen.restful.server.util.PushApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-02-10 12:35
 **/
@RestController
public class MessagePushController {
    @Resource
    private MessageGetService messageGetService;
    @Resource
    private MessagePostService messagePostService;
    @Resource
    PushApplicationContext pushApplicationContext;
    @GetMapping("/push")
    public String pushString(){
       return messageGetService.getString();
    }

    @GetMapping("/pushPost")
    public String pushPostString(){
        return messagePostService.postString();
    }

    @GetMapping("pushUrl")
    public String getPushUrl(){
        return pushApplicationContext.getAuthCenter();
    }
}

package com.xinwen.restful.client.controller;


import com.xinwen.restful.client.entity.UserDo;
import com.xinwen.restful.client.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-02-10 11:26
 **/
@RestController
public class MessageGetController {
    private static final Logger log= LoggerFactory.getLogger(MessageGetController.class);

    @GetMapping("/get")
    public Result<Void> getString(){
        return Result.success();
    }

    @PostMapping("/post")
    public Result<UserDo> post(@RequestBody UserDo userDo){
        log.info("请求结果：{}",userDo);
        UserDo userDo1 = new UserDo();
        userDo1.setAge(10);
        userDo1.setName("里斯");
        userDo1.setSex((byte) 20);
        return Result.success(userDo1);
    }

}

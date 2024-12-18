package com.xinwen.validation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.xinwen.validation.domain.Article2DTO;
import com.xinwen.validation.domain.ArticleDTO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-04-12 17:28
 **/
@RestController
public class UserController {

    @PostMapping("/add")
    public Object add(@Valid @RequestBody ArticleDTO articleDTO, BindingResult bindingResult) throws
            JsonProcessingException {
//如果有错误提示信息
        if (bindingResult.hasErrors()) {
            Map<String , String> map = new HashMap<>();
            bindingResult.getFieldErrors().forEach( (item) -> {
                String message = item.getDefaultMessage();
                String field = item.getField();
                map.put( field , message );
            } );
//返回提示信息
           // return objectMapper.writeValueAsString(map);
            return map;
        }
        return "success";
    }

    @PostMapping("/add2")
    public Object add2(@Validated(value = Article2DTO.class) @RequestBody ArticleDTO
                              articleDTO, BindingResult bindingResult) throws JsonProcessingException {
//如果有错误提示信息
        if (bindingResult.hasErrors()) {
            Map<String , String> map = new HashMap<>();
            bindingResult.getFieldErrors().forEach( (item) -> {
                String message = item.getDefaultMessage();
                String field = item.getField();
                map.put( field , message );
            } );
//返回提示信息
            return map;
        }
        return "success";
    }


}

package com.shenlx.xinwen.custom.auto.key.controller;

import com.shenlx.xinwen.custom.auto.key.service.KeyGeneratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 18:25
 */
@RestController
public class KeyController {
    @Resource
    private KeyGeneratorService keyGeneratorService;
    @GetMapping("/get/max")
    public Long getMax(){
        return keyGeneratorService.getKey();
    }

}

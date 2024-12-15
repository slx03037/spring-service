package com.xinwen.postgresql.node01.controller;

import com.xinwen.postgresql.node01.core.service.TheftRobberyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenlx
 * @description
 * @date 2024/9/12 11:44
 */
@RestController
@RequestMapping("api")
public class TheftRobberyController {
    @Autowired
    TheftRobberyService theftRobberyService;

    @GetMapping("/get")
    public String getTheftRobberyInfo(@RequestParam("cphm")String cphm){
        return theftRobberyService.query(cphm).get(0).toString();
    }
}

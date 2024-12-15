package com.xinwen.smart.doc.controller;

import com.xinwen.smart.doc.model.entity.ResponseResult;
import com.xinwen.smart.doc.model.query.UserParam;
import com.xinwen.smart.doc.model.vo.AddressVo;
import com.xinwen.smart.doc.model.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-07-11 15:50
 **/

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * Add user.
     *
     * @param userParam user param
     * @return user
     */
    @PostMapping("add")
    public ResponseResult<String> add(@RequestBody UserParam userParam) {
        return ResponseResult.success("success");
    }

    /**
     * User list.
     *
     * @return user list
     * @since 1.2
     */
    @GetMapping("list")
    public ResponseResult<List<UserVo>> list() {
        List<UserVo> userVoList = Collections.singletonList(UserVo.builder().name("dai").age(18)
                .address(AddressVo.builder().city("SZ").zipcode("10001").build()).build());
        return ResponseResult.success(userVoList);
    }
}

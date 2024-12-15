package com.xinwen.validation.domain;


import com.xinwen.validation.aspect.Validate;
import lombok.Data;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-04-14 16:42
 **/
@Data
public class AuthorDTO2Validate {
    @Validate(values = {1,2},message = "性别只能传入1或者2")
    private Integer gender;
}

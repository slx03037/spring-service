package com.xinwen.swagger.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-04-24 16:47
 **/
@Data
@Builder
public class AddressVo {
    private String city;
    private String zipcode;

}

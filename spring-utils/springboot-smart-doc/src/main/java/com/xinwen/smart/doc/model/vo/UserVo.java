package com.xinwen.smart.doc.model.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-07-11 15:49
 **/

@Data
@Builder
public class UserVo {

    /**
     * username.
     */
    private String name;

    /**
     * user's age.
     */
    private int age;

    /**
     * user's address.
     */
    private AddressVo address;
}
package com.xinwen.smart.doc.model.query;

import lombok.Builder;
import lombok.Data;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-07-11 15:48
 **/

@Data
@Builder
public class UserParam {

    /**
     * username.
     */
    private String name;

    /**
     * user age.
     */
    private int age;

    /**
     * user address.
     */
    private AddressParam address;
}

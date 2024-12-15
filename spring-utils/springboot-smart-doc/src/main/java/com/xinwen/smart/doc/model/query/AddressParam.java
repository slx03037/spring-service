package com.xinwen.smart.doc.model.query;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class AddressParam {

    /**
     * city.
     */
    private String city;

    /**
     * zip code.
     */
    private String zipcode;
}

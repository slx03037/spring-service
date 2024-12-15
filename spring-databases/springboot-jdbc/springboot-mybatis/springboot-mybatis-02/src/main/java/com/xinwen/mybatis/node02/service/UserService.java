package com.xinwen.mybatis.node02.service;

import java.util.List;
import java.util.Map;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-12 18:30
 **/

public interface UserService {
    List<Map<String, Object>> getAllDevs();
    List<Map<String, Object>> getAllProds();
}

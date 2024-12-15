package com.xinwen.jdbc.template.service;


import com.xinwen.jdbc.template.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-10 14:57
 **/

public interface UserService {
    int add(User user);
    int update(User user);
    int deleteBysno(String sno);
    List<Map<String, Object>> queryMap();
    User queryBySno(String sno);
}

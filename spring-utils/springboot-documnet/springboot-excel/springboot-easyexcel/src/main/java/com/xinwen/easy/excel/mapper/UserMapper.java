package com.xinwen.easy.excel.mapper;



import com.xinwen.easy.excel.entity.UserDO;

import java.util.List;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-06-29 14:31
 **/

public interface UserMapper {
    List<UserDO>  excelUserList();
}

package com.xinwen.jdbc.template.dao.mysql01.impl;


import com.xinwen.jdbc.template.dao.mysql01.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-10 15:56
 **/
@Repository
public class SysUserDaoImpl implements SysUserDao {

    @Autowired
    @Qualifier("mysql01JdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getUsers() {
        return this.jdbcTemplate.queryForList("select * from user");
    }

}

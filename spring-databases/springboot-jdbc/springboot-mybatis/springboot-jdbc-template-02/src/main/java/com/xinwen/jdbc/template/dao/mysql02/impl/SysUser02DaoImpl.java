package com.xinwen.jdbc.template.dao.mysql02.impl;


import com.xinwen.jdbc.template.dao.mysql02.SysUser02Dao;
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
 * @create: 2023-03-10 16:08
 **/
@Repository
public class SysUser02DaoImpl implements SysUser02Dao {

    @Autowired
    @Qualifier("mysql02JdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getUsers() {
        return this.jdbcTemplate.queryForList("select * from user");
    }
}

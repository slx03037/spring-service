package com.xinwen.jdbc.template.service.impl;

import com.xinwen.jdbc.template.dao.mysql01.SysUserDao;
import com.xinwen.jdbc.template.dao.mysql02.SysUser02Dao;
import com.xinwen.jdbc.template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-03-10 16:25
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUser02Dao sysUser02Dao;

    @Override
    public List<Map<String, Object>> getUsersMysql01() {
        return this.sysUserDao.getUsers();
    }

    @Override
    public List<Map<String, Object>> getUsersMysql02() {
        return this.sysUser02Dao.getUsers();
    }
}

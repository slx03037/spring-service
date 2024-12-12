package com.xinwen.postgresql.core.service.impl;

import com.xinwen.postgresql.core.entity.TheftRobbery;
import com.xinwen.postgresql.core.mapper.TheftRobberyMapper;
import com.xinwen.postgresql.core.service.TheftRobberyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shenlx
 * @description
 * @date 2024/9/12 10:58
 */
@Service
public class TheftRobberyServiceImpl implements TheftRobberyService {

    @Resource
    private TheftRobberyMapper theftRobberyMapper;

    @Override
    public List<TheftRobbery> query(String wpgg) {
        return theftRobberyMapper.query(wpgg);
    }
}

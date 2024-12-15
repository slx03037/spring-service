package com.xinwen.postgresql.node01.core.mapper;


import com.xinwen.postgresql.node01.core.entity.TheftRobbery;

import java.util.List;

/**
 * @author shenlx
 * @description
 * @date 2024/9/12 10:57
 */
public interface TheftRobberyMapper {

    List<TheftRobbery> query(String wpgg);
    int countAll();
}

package com.xinwen.postgresql.core.mapper;

import com.xinwen.postgresql.core.entity.TheftRobbery;

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

package com.xinwen.postgresql.core.service;

import com.xinwen.postgresql.core.entity.TheftRobbery;

import java.util.List;

/**
 * @author shenlx
 * @description
 * @date 2024/9/12 10:58
 */
public interface TheftRobberyService {

    List<TheftRobbery> query(String wpgg);
}

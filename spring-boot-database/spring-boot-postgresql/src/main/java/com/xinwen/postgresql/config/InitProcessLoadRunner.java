package com.xinwen.postgresql.config;

import com.xinwen.postgresql.core.mapper.TheftRobberyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author shenlx
 * @description
 * @date 2024/9/12 11:31
 */
@Order(value = 0) // 数字越小，越先执行
@Component
@Slf4j
public class InitProcessLoadRunner implements CommandLineRunner {
    @Autowired
    private TheftRobberyMapper theftRobberyMapper;

    @Override
    public void run(String... args) throws Exception {
        int row = theftRobberyMapper.countAll();
        log.warn("查询条数:{}",row);
    }

}

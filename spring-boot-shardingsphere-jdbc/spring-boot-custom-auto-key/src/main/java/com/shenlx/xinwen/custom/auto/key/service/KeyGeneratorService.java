package com.shenlx.xinwen.custom.auto.key.service;

import com.shenlx.xinwen.custom.auto.key.mapper.KeyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 18:22
 */
@Service
public class KeyGeneratorService {
    @Resource
    private KeyMapper keyMapper;

    public Long getKey(){
        return keyMapper.queryMaxCode();
    }
}

package com.shenlx.xinwen.shardingsphere.cutom.key.generator.service;

import com.shenlx.xinwen.shardingsphere.cutom.key.generator.entity.Order;
import com.shenlx.xinwen.shardingsphere.cutom.key.generator.mapper.OrderMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shenlx
 * @description
 * @date 2024/5/7 16:15
 */
@Service
public class OrderService {
    private final static String INTRODUCTION_HOUSE_PREFIX="order_id:gen";

    @Resource
    private RedisTemplate<String, Long> redisTemplate;

    @Resource
    private OrderMapper orderMapper;

    public void add(Order order){
        orderMapper.insert(order);
    }

    public List<Order> listPage(){
      return  orderMapper.listPage(0,10);
    }

    /**
     * 自动生成栋舍编码
     *
     * @return
     */
    public Long generateHouseCode() {
        String cacheKey = INTRODUCTION_HOUSE_PREFIX;
        Boolean hasKey = redisTemplate.hasKey(cacheKey);
        ValueOperations<String, Long> operations = redisTemplate.opsForValue();
        if (!hasKey) {
            Long maxCode = orderMapper.queryMaxCode();
            operations.set(cacheKey, maxCode);
        }
        Long code = operations.increment(cacheKey);
        return  code;
    }
}

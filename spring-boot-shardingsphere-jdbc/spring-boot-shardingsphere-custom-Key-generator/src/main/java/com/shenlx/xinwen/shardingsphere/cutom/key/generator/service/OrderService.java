package com.shenlx.xinwen.shardingsphere.cutom.key.generator.service;

import com.alibaba.fastjson2.JSON;
import com.shenlx.xinwen.shardingsphere.cutom.key.generator.entity.Order;
import com.shenlx.xinwen.shardingsphere.cutom.key.generator.mapper.OrderMapper;
import io.vertx.core.json.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shenlx
 * @description
 * @date 2024/5/7 16:15
 */
@Service
@Slf4j
public class OrderService {
    private final static String INTRODUCTION_HOUSE_PREFIX="ORDER_TYPE";

    @Resource
    private RedisTemplate<String, Integer> redisTemplate;

    @Resource
    private OrderMapper orderMapper;

//    public static void main(String[]args){
//        Map<String,String> map=new HashMap<>();
//        map.put("id","123");
//        String str="{\"id\":\"123\"}";
//        String string = JSON.toJSON(map).toString();
//        System.out.println(JSON.toJSON(map)+"======"+JSON.parse(string));
//    }

    public void add(Order order){
        Long l = generateHouseCode(order.getOrderType().toString());
        log.warn("id");
        order.setOrderId(l);
        orderMapper.insert(order);
    }

    public List<Order> listPage(Integer type){
      return  orderMapper.listPage(0,10,type);
    }

    /**
     * 自动生成栋舍编码
     *
     * @return
     */
    public Long generateHouseCode(String type) {
        String cacheKey = INTRODUCTION_HOUSE_PREFIX+type;
        Boolean hasKey = redisTemplate.hasKey(cacheKey);
        //Long maxCode=0L;
        ValueOperations<String, Integer> operations = redisTemplate.opsForValue();

        if (!hasKey) {
            Long maxCode = orderMapper.queryMaxCode();
            operations.set(cacheKey, maxCode.intValue());
        }
        Long increment = operations.increment(cacheKey);
        log.warn("获取的自增id:{}",increment);
        return  increment;
    }
}

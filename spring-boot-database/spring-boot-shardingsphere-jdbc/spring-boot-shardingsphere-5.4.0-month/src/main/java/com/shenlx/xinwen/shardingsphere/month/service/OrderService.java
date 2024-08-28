package com.shenlx.xinwen.shardingsphere.month.service;

import com.shenlx.xinwen.shardingsphere.month.entity.Order;
import com.shenlx.xinwen.shardingsphere.month.entity.OrderBO;
import com.shenlx.xinwen.shardingsphere.month.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Resource
    private OrderMapper orderMapper;

//    public static void main(String[]args){
//        Map<String,String> map=new HashMap<>();
//        map.put("id","123");
//        String str="{\"id\":\"123\"}";
//        String string = JSON.toJSON(map).toString();
//        System.out.println(JSON.toJSON(map)+"======"+JSON.parse(string));
//    }

    public void add(OrderBO orderBO){
        Order order=new Order();
        order.setOrderName(orderBO.getOrderName());
        order.setStatus(orderBO.getStatus());
        order.setOrderType(orderBO.getOrderType());
        LocalDateTime parse = LocalDateTime.parse(orderBO.getCreateTime(),DATE_TIME_FORMATTER);
        order.setCreateTime(parse);
        Long l = generateHouseCode(order.getOrderType().toString());
        log.warn("id");
        order.setOrderId(l);
        orderMapper.insert(order);
    }

    public List<Order> listPage(Integer type,String startTime,String endTime){
        LocalDateTime startDate =null;
        LocalDateTime endDate =LocalDateTime.now();
        if(StringUtils.isNotBlank(startTime)){
            startDate=LocalDateTime.parse(startTime,DATE_TIME_FORMATTER);
        }
        if(StringUtils.isNotBlank(endTime)){
            endDate=LocalDateTime.parse(endTime,DATE_TIME_FORMATTER);
        }

      return  orderMapper.listPage(0,10,type,startDate,endDate);
    }

    /**
     * 自动生成栋舍编码
     *
     * @return
     */
    public Long generateHouseCode(String type) {
        String cacheKey = INTRODUCTION_HOUSE_PREFIX+type+"10";
        Boolean hasKey = redisTemplate.hasKey(cacheKey);
        //Long maxCode=0L;
        ValueOperations<String, Integer> operations = redisTemplate.opsForValue();

        if (!hasKey) {
            LocalDateTime now = LocalDateTime.now();
            Long maxId = orderMapper.queryMaxId(now);
            Long maxCode = maxId == null ? 0 : maxId;
            operations.set(cacheKey, maxCode.intValue());
        }
        Long increment = operations.increment(cacheKey);
        log.warn("获取的自增id:{}",increment);
        return  increment;
    }
}

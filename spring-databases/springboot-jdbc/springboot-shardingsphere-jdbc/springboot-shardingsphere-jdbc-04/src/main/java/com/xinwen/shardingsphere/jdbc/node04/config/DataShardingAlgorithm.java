package com.xinwen.shardingsphere.jdbc.node04.config;


import com.xinwen.shardingsphere.jdbc.node04.config.bean.RestTemplateReadyListener;
import com.xinwen.shardingsphere.jdbc.node04.enums.IllegalTypeEnum;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * @author shenlx
 * @description 安装order_type分类
 * @date 2024/5/8 14:53
 */
@Getter
@Slf4j
public class DataShardingAlgorithm implements StandardShardingAlgorithm<Integer> {

    private Properties props;

    private final static String PREFIX_STR="ORDER_TYPE";


    /**
     * 在配置文件中配置算法的时候会配置 props 参数，框架会将props中的配置放在 properties 参数中，并且初始化算法的时候被调用
     *
     * @param properties properties
     */
    @Override
    public void init(Properties properties) {
        this.props = properties;
    }

    /**
     * 精确路由算法
     *
     * @param availableTargetNames 可用的表列表（配置文件中配置的 actual-data-nodes会被解析成 列表被传递过来）
     * @param shardingValue        精确的值
     * @return 结果表
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> shardingValue) {
        log.warn("分表依据:{}",availableTargetNames);
        int value = shardingValue.getValue();
        // 根据精确值获取路由表
        int  type= IllegalTypeEnum.getType((value));

        Long code = generateKey(String.valueOf(value))%2L;
        int  shardingSuffixValue=code==0L?type:++(type);
        //根据id进行加一
        String actuallyTableName = shardingValue.getLogicTableName() +"_"+ shardingSuffixValue;
        if (availableTargetNames.contains(actuallyTableName)) {
            return actuallyTableName;
        }
        return null;
    }


    private Long generateKey(String type){
        RedisTemplate redisTemplates = RestTemplateReadyListener.getRedisTemplateHolder().getRedisTemplate();
        RestTemplate restTemplate=RestTemplateReadyListener.getRestTemplateHolder().getRestTemplate();
        log.warn("redis:id:{}",redisTemplates.isExposeConnection());
        String redisKey = PREFIX_STR + type;
        Boolean b = redisTemplates.hasKey(redisKey);
        ValueOperations<String, Integer> operations = redisTemplates.opsForValue();
        if(!b){
            ResponseEntity<Long> bean = restTemplate.getForEntity("localhost:8080/get/max", Long.class);
            Long maxCode = bean.getBody();
            operations.set(redisKey, maxCode.intValue());
        }
        Integer code = operations.get(redisKey);

        log.warn("获取body");
        return code.longValue();
    }


    /**
     * 范围路由算法
     *
     * @param availableTargetNames 可用的表列表（配置文件中配置的 actual-data-nodes会被解析成 列表被传递过来）
     * @param shardingValue        值范围
     * @return 路由后的结果表
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Integer> shardingValue) {
        String logicTableName = shardingValue.getLogicTableName();
        String columnName = shardingValue.getColumnName();
        log.warn("数据查询");
        // 获取到范围查找的最小值，如果条件中没有最小值设置为 tableLowerDate
        //Date rangeLowerDate;
//        if (shardingValue.getValueRange().hasLowerBound()) {
//            rangeLowerDate = shardingValue.getValueRange().lowerEndpoint();
//        } else {
//            rangeLowerDate = tableLowerDate;
//        }
//
//        // 获取到范围查找的最大值，如果没有配置最大值，设置为当前时间 + 1 月
//        // 这里需要注意，你的项目里面这样做是否合理
//        Date rangeUpperDate;
//        if (shardingValue.getValueRange().hasUpperBound()) {
//            rangeUpperDate = shardingValue.getValueRange().upperEndpoint();
//        } else {
//            // 往后延一个月
//            rangeUpperDate = DateUtil.offsetMonth(new Date(), 1);
//        }
//        rangeUpperDate = DateUtil.endOfMonth(rangeUpperDate);
        List<String> tableNames = new ArrayList<>();
        log.warn("数据查询：{}",tableNames);
//        // 过滤那些存在的表
//        while (rangeLowerDate.before(rangeUpperDate)) {
//            String actuallyTableName = shardingValue.getLogicTableName() + shardingSuffix(rangeLowerDate);
//            if (availableTargetNames.contains(actuallyTableName)) {
//                tableNames.add(actuallyTableName);
//            }
//            //rangeLowerDate = DateUtil.offsetMonth(rangeLowerDate, 1);
//        }
       // return ;
        return tableNames;
    }

    /**
     * sharding 表后缀 _yyyyMM
     */
//    private String shardingSuffix(Date shardingValue) {
//        return "_" + formatThreadLocal.get().format(shardingValue);
//    }

    /**
     * SPI方式的 SPI名称，配置文件中配置的时候需要用到
     */
    @Override
    public String getType() {
        return "HIS_ORDER_TYPE_SPI_BASED";
    }

}

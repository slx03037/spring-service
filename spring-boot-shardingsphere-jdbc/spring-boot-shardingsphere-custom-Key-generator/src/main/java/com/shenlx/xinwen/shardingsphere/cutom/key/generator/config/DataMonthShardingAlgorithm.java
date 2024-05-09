package com.shenlx.xinwen.shardingsphere.cutom.key.generator.config;

import com.shenlx.xinwen.shardingsphere.cutom.key.generator.enums.IllegalTypeEnum;
import com.shenlx.xinwen.shardingsphere.cutom.key.generator.redis.RestTemplateReadyListener;
import com.shenlx.xinwen.shardingsphere.cutom.key.generator.service.OrderService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import org.springframework.data.redis.core.RedisTemplate;

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
public class DataMonthShardingAlgorithm implements StandardShardingAlgorithm<Long> {

    private OrderService orderService;

    private Properties props;

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
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        Long value = shardingValue.getValue();
        // 根据精确值获取路由表
        int  type= IllegalTypeEnum.gets((value));
        Long code = generateKey()%2L;
        int  shardingSuffixValue=code==0L?type:++type;
        //根据id进行加一
        String actuallyTableName = shardingValue.getLogicTableName() + shardingSuffixValue;
        if (availableTargetNames.contains(actuallyTableName)) {
            return actuallyTableName;
        }
        return null;
    }

//    public static void main(String[]args){
//        Long ss =1090L/100;
//        log.warn("ss:{}",ss);
//        int i = 0 % 2;
//        int a=0;
//        int b=0;
//        a= 1%2==0?0:a++;
//        log.warn("a:{}",a);
//        b =1%2==0?0:++b;
//        log.warn("b:{}",b);
//        log.warn("取余:{}",i);
//    }

    private Long generateKey(){
        RedisTemplate redisTemplate = RestTemplateReadyListener.getRedisTemplateHolder().getRedisTemplate();
        log.warn("redis:id:{}",redisTemplate.isExposeConnection());
        Long code = orderService.generateHouseCode();
        return code;
    }


    /**
     * 范围路由算法
     *
     * @param availableTargetNames 可用的表列表（配置文件中配置的 actual-data-nodes会被解析成 列表被传递过来）
     * @param shardingValue        值范围
     * @return 路由后的结果表
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> shardingValue) {
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

//package com.shenlx.xinwen.shardingsphere.cutom.key.generator.config;
//
//import com.google.common.base.Preconditions;
//import lombok.Data;
//import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
//import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
//import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.Properties;
//
///**
// * @author shenlx
// * @description
// * @date 2024/5/8 9:43
// */
//@Data
//@Component
//public class UserIdSharding implements StandardShardingAlgorithm<String> {
//    private static final String SHARDING_COUNT_KEY = "sharding-count";
//
//    /**
//     * 对应props配置
//     */
//    private Properties props = new Properties();
//
//    private int shardingCount;
//
//    /**
//     * 初始化调用
//     */
//
//    @Override
//    public void init(Properties properties) {
//        shardingCount = getShardingCount();
//    }
//
//    private int getShardingCount() {
//        Preconditions.checkArgument(props.containsKey(SHARDING_COUNT_KEY), "Sharding count cannot be null.");
//        return Integer.parseInt(props.get(SHARDING_COUNT_KEY).toString());
//    }
//    /**
//     * Standard Sharding
//     * @param availableTargetNames real table
//     * @param preciseShardingValue Single Sharding key
//     * @return
//     */
//    @Override
//    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> preciseShardingValue) {
//        long l = Long.parseLong(preciseShardingValue.getValue()) % shardingCount;
//        for (String availableTargetName : availableTargetNames) {
//            if (availableTargetName.endsWith(String.valueOf(l))) {
//                return availableTargetName;
//            }
//        }
//
//        return null;
//    }
//
//    /**
//     * Complex Sharding
//     * @param availableTargetNames real table
//     * @param rangeShardingValue Multiple Sharding Key
//     * @return
//     */
//    @Override
//    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> rangeShardingValue) {
//        return null;
//    }
//
//    /**
//     * SPI根据配置Type获取
//     * @return
//     */
//    @Override
//    public String getType() {
//        return "ORDER_TYPE";
//    }
//}

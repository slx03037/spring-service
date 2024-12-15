package com.xinwen.shardingsphere.jdbc.node03.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Properties;

/**
 * @author shenlx
 * @description
 * @date 2024/5/8 10:37
 */

@Component
@Slf4j
public class TableShardingAlgorithm implements StandardShardingAlgorithm<Long> {
    private Properties props;

    // @Value("${sharding.shardcount}")
    private Long shardCount = 2L;


    @Override
    public Properties getProps() {
        return props;
    }

    @Override
    public void setProps(Properties props) {
        this.props = props;
    }

    @Override
    public String doSharding(Collection<String> tableNames, PreciseShardingValue<Long> shardingValue) {

        Long lShard = 0L;
        lShard = shardingValue.getValue();

        // 读取设置的参数
        if(props != null)
        {
            String shardCountStr = props.getProperty("shardCount", "2");
            shardCount = Long.parseLong(shardCountStr);
        }

        Long lowMod = lShard % 2;


        Long shardTableMod = lowMod;

        // 转换为带格式的字符串
        String shardModStr = "_" + shardTableMod;

        for (String table : tableNames) {
            if (table.endsWith(shardModStr)) {
                return table;
            }
        }

        return "";
    }

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return "ORDER_ID_SHARD";

    }

    @Override
    public void init() {
        // TODO Auto-generated method stub

    }

    @Override
    public Collection<String> doSharding(Collection<String> tableNames,
                                         RangeShardingValue<Long> shardingValue) {

        return null;

    }
}

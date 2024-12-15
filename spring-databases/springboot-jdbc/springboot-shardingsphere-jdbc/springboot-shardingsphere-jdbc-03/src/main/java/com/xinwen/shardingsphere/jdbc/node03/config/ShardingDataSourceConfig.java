package com.xinwen.shardingsphere.jdbc.node03.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

import com.xinwen.shardingsphere.jdbc.node03.config.prop.DruidProperties;
import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.config.algorithm.ShardingSphereAlgorithmConfiguration;
import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.strategy.keygen.KeyGenerateStrategyConfiguration;
import org.apache.shardingsphere.sharding.api.config.strategy.sharding.StandardShardingStrategyConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author shenlx
 * @description
 * @date 2024/5/8 10:20
 */
@Configuration
public class ShardingDataSourceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.druid.shardsource")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.shardsource", name = "enabled", havingValue = "true")
    public DataSource shardDataSource(DruidProperties druidProperties)
    {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return druidProperties.dataSource(dataSource);
    }

    @Bean(name = "shardingDataSource")
    public DataSource shardingDataSource(@Qualifier("shardDataSource") DataSource shardDataSource) throws SQLException
    {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("order", shardDataSource);
        // dataSourceMap.put("order2", order2DataSource);

        // sys_order 表规则配置
        // TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration("sys_order", "order$->{1..2}.sys_order_$->{0..1}");

        ShardingTableRuleConfiguration orderTableRuleConfig = new ShardingTableRuleConfiguration("sys_order", "order.sys_order_$->{0..1}");

        orderTableRuleConfig.setTableShardingStrategy(
                new StandardShardingStrategyConfiguration("order_id", "tableShardingAlgorithm"));

        // 配置分库策略
        // orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "order$->{user_id % 2 + 1}"));
        // 配置分表策略
        // orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id", "sys_order_$->{order_id % 2}"));

        // 分布式主键
        orderTableRuleConfig.setKeyGenerateStrategy(new KeyGenerateStrategyConfiguration("order_id", "snowflake"));

        // 配置分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTables().add(orderTableRuleConfig);

        Properties pDatabase = new Properties();
        pDatabase.setProperty("shardCount", "2");

        // 设置分表策略
        ShardingSphereAlgorithmConfiguration ssactable = new ShardingSphereAlgorithmConfiguration(
                "ORDER_ID_SHARD", pDatabase);
        shardingRuleConfig.getShardingAlgorithms().put("tableShardingAlgorithm", ssactable);

        // 内置Snowflake分布式序列算法配置
        Properties snowflakeProp = new Properties();
        snowflakeProp.setProperty("worker-id", "1");
        shardingRuleConfig.getKeyGenerators().put("snowflake",
                new ShardingSphereAlgorithmConfiguration("SNOWFLAKE", snowflakeProp));

        // 获取数据源对象
        DataSource dataSource = ShardingSphereDataSourceFactory.createDataSource(dataSourceMap,
                Collections.singleton(shardingRuleConfig),
                getProperties());
        return dataSource;
    }

    /**
     * 系统参数配置
     */
    private Properties getProperties()
    {
        Properties shardingProperties = new Properties();
        shardingProperties.put("sql.show", true);
        return shardingProperties;
    }
}

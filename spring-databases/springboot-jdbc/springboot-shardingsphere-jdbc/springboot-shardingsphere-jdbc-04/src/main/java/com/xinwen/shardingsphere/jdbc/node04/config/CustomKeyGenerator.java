package com.xinwen.shardingsphere.jdbc.node04.config;


import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.spi.KeyGenerateAlgorithm;

import java.util.Properties;

/**
 * @author shenlx
 * @description
 * @date 2024/5/8 18:09
 */
@Slf4j
public class CustomKeyGenerator implements KeyGenerateAlgorithm {
    private final static String type="custom_generate_key";

    /**
     * 这是生成主键的核心逻辑所在。在这个方法内部，我们可以根据业务需求选择合适的主键生成算法
     * @return
     */
    @Override
    public Comparable<?> generateKey() {
        log.warn("运行id自增");
        return null;
    }

    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public void init(Properties properties) {

    }

    @Override
    public String getType() {
        //return KeyGenerateAlgorithm.super.getType();
        return "custom_generate_key";
    }



}

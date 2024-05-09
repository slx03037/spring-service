//package com.shenlx.xinwen.shardingsphere.cutom.key.generator.config;
//
//import com.shenlx.xinwen.shardingsphere.cutom.key.generator.service.OrderService;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shardingsphere.sharding.spi.KeyGenerateAlgorithm;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.Properties;
//
///**
// * @author shenlx
// * @description
// * @date 2024/5/7 16:18
// */
//@Getter
//@Slf4j
////@Component
//public  class MyShardingKeyGenerator implements KeyGenerateAlgorithm {
//
////    @Resource
//    private OrderService orderService;
//    //private Properties properties = new Properties();
//
//    private final String type = "orderId";
//
//    @Setter
//    private Properties properties = new Properties();
//    @Override
//    public Comparable<?> generateKey() {
//        // 实现自定义主键生成规则，自定义实现
//        //String nowDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
//        Long code = orderService.generateHouseCode();
//        //log.warn("code:{}",code);
//        return 1;
//    }
//
//    @Override
//    public String getType() {
//        // 指定主键生成的类型，对应到sharding-jdbc分片规则中的defaultKeyGenerator.type或者keyGenerator.type的值
//        return type;
//    }
//
//
//    @Override
//    public Properties getProps() {
//        log.warn("properties:{}",properties);
//        return properties;
//    }
//
//    @Override
//    public void init(Properties properties) {
//
//    }
//}

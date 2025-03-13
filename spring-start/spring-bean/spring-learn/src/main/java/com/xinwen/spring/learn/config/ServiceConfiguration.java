package com.xinwen.spring.learn.config;

import com.xinwen.spring.learn.service.InventoryService;
import com.xinwen.spring.learn.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shenlx
 * @description
 * @date 2025/3/6 10:58
 */
@Configuration
public class ServiceConfiguration {
    @Bean
    public InventoryService inventoryService() {
        return new InventoryService();
    }

    @Bean
    public ProductService productService() {
        return new ProductService(inventoryService());
    }
}

package com.xinwen.caffeine.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.xinwen.caffeine.common.CacheEnum;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author shenlx
 * @description
 * @date 2025/1/21 11:08
 */
public class CacheConfig {

    /**
     * Caffeine配置说明：
     * initialCapacity=[integer]: 初始的缓存空间大小
     * maximumSize=[long]: 缓存的最大条数
     * maximumWeight=[long]: 缓存的最大权重
     * expireAfterAccess=[duration]: 最后一次写入或访问后经过固定时间过期
     * expireAfterWrite=[duration]: 最后一次写入后经过固定时间过期
     * refreshAfterWrite=[duration]: 创建缓存或者最近一次更新缓存后经过固定的时间间隔，刷新缓存
     * weakKeys: 打开key的弱引用
     * weakValues：打开value的弱引用
     * softValues：打开value的软引用
     * recordStats：开发统计功能
     *
     * 注意：
     * expireAfterWrite和expireAfterAccess同事存在时，以expireAfterWrite为准。
     * maximumSize和maximumWeight不可以同时使用
     * weakValues和softValues不可以同时使用
     */

    @Bean
    public CacheManager cacheManager(){
        SimpleCacheManager cacheManager=new SimpleCacheManager();
        List<CaffeineCache> list = new ArrayList<>();
        //循环添加枚举类中自定义的缓存，可以自定义
        for(CacheEnum cacheEnum:CacheEnum.values()){
            list.add(new CaffeineCache(cacheEnum.getName()
                    , Caffeine.newBuilder()
                    .initialCapacity(50)
                    .maximumSize(1000)
                    .expireAfterAccess(cacheEnum.getExpires(), TimeUnit.SECONDS)
                    .build()));
        }
        cacheManager.setCaches(list);
        return cacheManager;
    }
}

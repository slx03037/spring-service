package com.shenlx.xinwen.shardingsphere.cutom.key.generator.redis;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author shenlx
 * @description
 * @date 2024/5/8 17:05
 */
public class RestTemplateReadyListener implements ApplicationListener<ApplicationReadyEvent> {
    private static RedisTemplateHolder redisTemplateHolder;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        ConfigurableApplicationContext applicationContext = event.getApplicationContext();
        RedisTemplate bean = (RedisTemplate) applicationContext.getBean("redisTemplate");
        redisTemplateHolder = new RedisTemplateHolder(bean);
    }

    public static RedisTemplateHolder getRedisTemplateHolder() {
        return redisTemplateHolder;
    }

    public class RedisTemplateHolder {
        private final RedisTemplate redisTemplate;

        public RedisTemplateHolder(RedisTemplate bean) {
            redisTemplate = bean;
        }

        public RedisTemplate getRedisTemplate() {
            return redisTemplate;
        }
    }
}

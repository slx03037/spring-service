package com.shenlx.xinwen.shardingsphere.cutom.key.generator.config.bean;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * @author shenlx
 * @description
 * @date 2024/5/8 17:05
 */
public class RestTemplateReadyListener implements ApplicationListener<ApplicationReadyEvent> {
    private static RedisTemplateHolder redisTemplateHolder;

    private static RestTemplateHolder restTemplateHolder;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        ConfigurableApplicationContext applicationContext = event.getApplicationContext();
        RedisTemplate bean = (RedisTemplate) applicationContext.getBean("redisTemplate");
        redisTemplateHolder = new RedisTemplateHolder(bean);
        RestTemplate restTemplate = (RestTemplate)applicationContext.getBean("restTemplate");
        restTemplateHolder=new RestTemplateHolder(restTemplate);
    }

    public static RedisTemplateHolder getRedisTemplateHolder() {
        return redisTemplateHolder;
    }

    public static RestTemplateHolder getRestTemplateHolder() {
        return restTemplateHolder;
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

    public class  RestTemplateHolder{
        private final RestTemplate restTemplate;

        public RestTemplateHolder(RestTemplate bean){
            restTemplate=bean;
        }

        public RestTemplate getRestTemplate(){
            return restTemplate;
        }
    }
}

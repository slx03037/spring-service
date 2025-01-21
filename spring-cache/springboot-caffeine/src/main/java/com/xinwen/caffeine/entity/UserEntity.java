package com.xinwen.caffeine.entity;

import com.xinwen.caffeine.common.CacheConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author shenlx
 * @description
 * @date 2025/1/21 11:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    private Integer userId;
    private String name;
    private Integer age;
}

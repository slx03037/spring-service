package com.xinwen.dgraph4j.entity;

import lombok.Data;

/**
 * @author shenlx
 * @description
 * @date 2025/2/14 15:18
 */
@Data
public class Follows {
    private String fromUid;
    private String toUid;
}

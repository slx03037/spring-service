package com.xinwen.dgraph4j.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author shenlx
 * @description
 * @date 2025/2/14 15:15
 */
@Data
public class User {
    private String uid;// Unique identifier for the user
    private String name;
    private String email;

    public boolean isValid() {
        return StringUtils.isNotBlank(name) && StringUtils.isNotBlank(email);
    }
}

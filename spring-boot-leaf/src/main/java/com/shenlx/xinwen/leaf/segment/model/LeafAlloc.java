package com.shenlx.xinwen.leaf.segment.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 15:04
 */
@Getter
@Setter
public class LeafAlloc {
    private String key;

    private long maxId;

    private int step;

    private String updateTime;
}

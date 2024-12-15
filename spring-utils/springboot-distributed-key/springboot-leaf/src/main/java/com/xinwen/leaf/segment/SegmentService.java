package com.xinwen.leaf.segment;


import com.xinwen.leaf.common.Result;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 16:31
 */
public interface SegmentService {
    Result getId(String key);

    SegmentIDGenImpl getIdGen();
}

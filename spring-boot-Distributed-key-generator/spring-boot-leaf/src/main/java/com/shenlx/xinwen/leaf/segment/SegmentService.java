package com.shenlx.xinwen.leaf.segment;

import com.shenlx.xinwen.leaf.common.Result;
import com.shenlx.xinwen.leaf.segment.SegmentIDGenImpl;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 16:31
 */
public interface SegmentService {
    Result getId(String key);

    SegmentIDGenImpl getIdGen();
}

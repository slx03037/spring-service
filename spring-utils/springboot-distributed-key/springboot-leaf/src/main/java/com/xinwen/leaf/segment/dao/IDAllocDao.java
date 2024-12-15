package com.xinwen.leaf.segment.dao;



import com.xinwen.leaf.segment.model.LeafAlloc;

import java.util.List;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 15:05
 */
public interface IDAllocDao {
    List<LeafAlloc> getAllLeafAllocs();

    LeafAlloc updateMaxIdAndGetLeafAlloc(String tag);

    LeafAlloc updateMaxIdByCustomStepAndGetLeafAlloc(LeafAlloc leafAlloc);

    List<String> getAllTags();
}

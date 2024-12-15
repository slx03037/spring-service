package com.xinwen.leaf;


import com.xinwen.leaf.common.Result;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 14:51
 */
public interface IDGen {
    Result get(String key);

    boolean init();
}

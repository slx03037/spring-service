package com.shenlx.xinwen.leaf;

import com.shenlx.xinwen.leaf.common.Result;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 14:51
 */
public interface IDGen {
    Result get(String key);

    boolean init();
}

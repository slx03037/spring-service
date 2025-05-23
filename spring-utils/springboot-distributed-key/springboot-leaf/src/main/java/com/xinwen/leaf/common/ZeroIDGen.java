package com.xinwen.leaf.common;


import com.xinwen.leaf.IDGen;
import com.xinwen.leaf.common.enums.Status;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 14:53
 */
public class ZeroIDGen implements IDGen {
    @Override
    public Result get(String key) {
        return new Result(0, Status.SUCCESS);
    }

    @Override
    public boolean init() {
        return true;
    }
}

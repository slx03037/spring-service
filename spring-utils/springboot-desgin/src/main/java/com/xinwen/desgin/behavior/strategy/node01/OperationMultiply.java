package com.xinwen.desgin.behavior.strategy.node01;

/**
 * @author shenlx
 * @description
 * @date 2024/10/8 15:35
 */
public class OperationMultiply implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1*num2;
    }
}

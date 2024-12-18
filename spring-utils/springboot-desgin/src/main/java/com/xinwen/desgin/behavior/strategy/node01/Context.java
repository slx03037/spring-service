package com.xinwen.desgin.behavior.strategy.node01;

/**
 * @author shenlx
 * @description
 * @date 2024/10/8 15:36
 */
public class Context {
    private final Strategy strategy;

    public Context(Strategy strategy){
        this.strategy=strategy;
    }

    public int executeStrategy(int num1,int num2){
        return strategy.doOperation(num1,num2);
    }
}

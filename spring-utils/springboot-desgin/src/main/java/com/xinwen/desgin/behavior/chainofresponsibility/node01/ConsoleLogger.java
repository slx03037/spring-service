package com.xinwen.desgin.behavior.chainofresponsibility.node01;

/**
 * @author shenlx
 * @description
 * @date 2024/10/12 15:29
 */
public class ConsoleLogger extends AbstractLogger{

    public  ConsoleLogger(int level){
        this.level=level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console:Logger"+message);
    }
}

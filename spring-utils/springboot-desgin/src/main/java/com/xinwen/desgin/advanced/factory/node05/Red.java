package com.xinwen.desgin.advanced.factory.node05;

/**
 * @author shenlx
 * @description
 * @date 2024/8/15 16:53
 */
public class Red implements Color{
    @Override
    public void fill() {
        System.out.println("Inside Red:fill() method.");
    }
}

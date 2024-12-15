package com.xinwen.desgin.advanced.factory.node06;

/**
 * @author shenlx
 * @description
 * @date 2024/8/15 17:29
 */
public class DFCar extends CarProduct{
    @Override
    void material() {
        System.out.println(super.name+"材料");
    }

    @Override
    void origin() {
        System.out.println(super.date+":"+super.name+"在中国南京生产");
    }
}

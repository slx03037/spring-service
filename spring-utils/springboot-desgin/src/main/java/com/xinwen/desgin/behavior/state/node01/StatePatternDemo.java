package com.xinwen.desgin.behavior.state.node01;

import com.xinwen.desgin.behavior.iterator.node02.ConcreteAggregate;

/**
 * @author shenlx
 * @description
 * @date 2024/10/11 16:47
 */
public class StatePatternDemo {
    public static void main(String[]args){
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());
    }
}

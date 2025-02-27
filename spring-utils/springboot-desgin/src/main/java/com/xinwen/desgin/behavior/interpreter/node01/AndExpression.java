package com.xinwen.desgin.behavior.interpreter.node01;

/**
 * @author shenlx
 * @description
 * @date 2024/10/11 11:17
 */
public class AndExpression implements Expression{
    private Expression expre1=null;

    private Expression expre2=null;

    public AndExpression(Expression expre1, Expression expre2) {
        this.expre1 = expre1;
        this.expre2 = expre2;
    }

    @Override
    public boolean interpret(String context) {
        return expre1.interpret(context) && expre2.interpret(context);
    }
}

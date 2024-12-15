package com.xinwen.desgin.structure.bridge.node01;

/**
 * @author shenlx
 * @description
 * @date 2024/9/10 16:09
 */
public class Circle extends Shape{

    private final int x;
    private final int y;
    private final int radius;
    protected Circle(int x,int y,int radius,DrawAPI drawAPI) {
        super(drawAPI);
        this.x=x;
        this.y=y;
        this.radius=radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}

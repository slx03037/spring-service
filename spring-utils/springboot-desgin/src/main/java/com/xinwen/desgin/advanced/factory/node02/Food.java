package com.xinwen.desgin.advanced.factory.node02;

import javax.swing.plaf.PanelUI;

/**
 * @author shenlx
 * @description
 * @date 2024/8/14 15:11
 */
public abstract class Food {
    protected  String name;

    public abstract void foodMaterial();

    public void cookFood(){
        System.out.println("食品烹饪："+name);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
}

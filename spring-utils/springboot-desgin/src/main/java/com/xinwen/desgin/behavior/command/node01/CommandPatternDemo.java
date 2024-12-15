package com.xinwen.desgin.behavior.command.node01;

/**
 * @author shenlx
 * @description
 * @date 2024/10/9 15:40
 */
public class CommandPatternDemo {

    public static void main(String[]args){
        Stock abcStock=new Stock();

        BuyStock buyStock = new BuyStock(abcStock);

        SellStock sellStock = new SellStock(abcStock);

        Broker broker = new Broker();

        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);

        broker.placeOrders();
    }
}

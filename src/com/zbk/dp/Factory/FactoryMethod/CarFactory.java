package com.zbk.dp.Factory.FactoryMethod;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-09 00:42
 **/
public class CarFactory {
    public Car create(){
        //比如说在创建car之前要进行日志操作
        System.out.println("a car created");
        return new Car();
    }
}

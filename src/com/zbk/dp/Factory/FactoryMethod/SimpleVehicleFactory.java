package com.zbk.dp.Factory.FactoryMethod;

/**
 * @program: Tank
 * @description: 交通工具生产--简单工厂
 * 这种方式很简单,但是可扩展性不好
 * @author: Des
 * @create: 2020-06-09 00:38
 **/
public class SimpleVehicleFactory {
    public Car createCar(){
        return new Car();
    }

    public Broom createBroom(){
        return new Broom();
    }

    public Plane createPlane(){
        return new Plane();
    }
}

package com.zbk.dp.Factory.abstractFactory;

import com.zbk.dp.Factory.FactoryMethod.Moveable;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-09 00:22
 **/
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory  = new ModenFactory();
        Food food = factory.createFood();
        food.printName();
        Vehicle vehicle = factory.createVehicle();
        vehicle.go();
        Weapon weapon = factory.createWeapon();
        weapon.shoot();
    }
}

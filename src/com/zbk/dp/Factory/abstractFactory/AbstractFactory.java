package com.zbk.dp.Factory.abstractFactory;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-09 02:12
 **/
public abstract class AbstractFactory {
    public abstract Food createFood();
    public abstract Weapon createWeapon();
    public abstract Vehicle createVehicle();

}

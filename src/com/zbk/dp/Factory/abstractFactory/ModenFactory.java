package com.zbk.dp.Factory.abstractFactory;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-09 02:14
 **/
public class ModenFactory extends AbstractFactory {
    @Override
    public Food createFood() {
        return new Bread();
    }

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

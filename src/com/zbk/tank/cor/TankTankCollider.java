package com.zbk.tank.cor;

import com.zbk.tank.Dir;
import com.zbk.tank.GameObject;
import com.zbk.tank.abstractFactory.BaseTank;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-07-14 01:48
 **/
public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseTank && o2 instanceof BaseTank){
            BaseTank t1 = (BaseTank) o1;
            BaseTank t2 = (BaseTank) o2;
            if (t1.getRect().intersects(t2.getRect())) {
                if (t1.getX() > t2.getX()){
                    t1.setDir(Dir.RIGHT);
                    t2.setDir(Dir.LEFT);
                }else {
                    t1.setDir(Dir.LEFT);
                    t2.setDir(Dir.RIGHT);
                }

            }
            return true;
        }else
            return false;
    }
}

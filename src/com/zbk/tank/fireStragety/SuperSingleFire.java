package com.zbk.tank.fireStragety;

import com.zbk.tank.Bullet;
import com.zbk.tank.Dir;
import com.zbk.tank.Group;
import com.zbk.tank.Tank;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-08 01:01
 **/
public class SuperSingleFire implements FireStragety {
    @Override
    public void fireWay(Tank tank) {
        int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        if (tank.getGroup() == Group.BAD){
            tank.getGm().add(new Bullet(bX, bY, tank.getDir(),Group.BAD, tank.getGm(), 10 * Bullet.WIDTH, 10* Bullet.HEIGHT));
        }else {
            tank.getGm().add(new Bullet(bX, bY, tank.getDir(),Group.GOOD, tank.getGm()));
        }
    }
}

package com.zbk.tank.fireStragety;

import com.zbk.tank.Bullet;
import com.zbk.tank.Group;
import com.zbk.tank.Tank;

/**
 * @program: Tank
 * @description: default way to fire
 * @author: Des
 * @create: 2020-06-08 00:53
 **/
public class DefaultFire implements FireStragety {
    @Override
    public void fireWay(Tank tank) {
        int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        if (tank.getGroup() == Group.BAD){
            tank.getGm().add(new Bullet(bX, bY, tank.getDir(),Group.BAD, tank.getGm()));
        }else {
            tank.getGm().add(tank.getGm().factory.reateBullet(bX, bY, tank.getDir(), Group.GOOD,tank.getGm()));
        }

    }
}

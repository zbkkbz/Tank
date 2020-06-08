package com.zbk.tank.fireStragety;

import com.zbk.tank.Bullet;
import com.zbk.tank.Dir;
import com.zbk.tank.Group;
import com.zbk.tank.Tank;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-08 00:58
 **/
public class AllDirFire implements FireStragety {
    @Override
    public void fireWay(Tank tank) {
        int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        if (tank.getGroup() == Group.BAD){
            tank.getTankFrame().bulletList.add(new Bullet(bX, bY, Dir.UP,Group.BAD, tank.getTankFrame()));
            tank.getTankFrame().bulletList.add(new Bullet(bX, bY, Dir.DOWN,Group.BAD, tank.getTankFrame()));
            tank.getTankFrame().bulletList.add(new Bullet(bX, bY, Dir.LEFT,Group.BAD, tank.getTankFrame()));
            tank.getTankFrame().bulletList.add(new Bullet(bX, bY, Dir.RIGHT,Group.BAD, tank.getTankFrame()));
        }else {
            tank.getTankFrame().bulletList.add(new Bullet(bX, bY, tank.getDir(),Group.GOOD, tank.getTankFrame()));
        }
    }
}

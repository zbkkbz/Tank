package com.zbk.tank.cor;

import com.zbk.tank.Explode;
import com.zbk.tank.GameObject;
import com.zbk.tank.Tank;
import com.zbk.tank.abstractFactory.BaseBullet;
import com.zbk.tank.abstractFactory.BaseTank;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-07-14 01:23
 **/
public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof BaseBullet && o2 instanceof BaseTank) {
            BaseBullet b = (BaseBullet) o1;
            BaseTank t = (BaseTank) o2;
            if (b.getGroup() == t.getGroup())
                return true;

            //判断两个矩形是否有相交的地方
            if (b.getRect().intersects(t.getRect())) {
                t.die();
                b.die();
                int eX = t.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
                int eY = t.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;

                t.getGm().add(t.getGm().factory.createExplode(b.getX(), b.getY(), t.getGm()));
            }
            return true;
        } else if (o2 instanceof BaseBullet && o1 instanceof BaseTank) {
            return collide(o2, o1);
        } else {
            return false;
        }
    }
}

package com.zbk.tank.abstractFactory;

import com.zbk.tank.*;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-10 01:21
 **/
public class DefaultFactory extends GameFactory{
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Tank(x, y, dir,group,tankFrame);
    }

    @Override
    public BaseBullet reateBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Bullet(x, y, dir, group, tankFrame);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new Explode(x, y, tankFrame);
    }
}

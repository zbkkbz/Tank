package com.zbk.tank.abstractFactory;

import com.zbk.tank.Dir;
import com.zbk.tank.Group;
import com.zbk.tank.TankFrame;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-10 01:38
 **/
public class RectFactory extends GameFactory {

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new RectTank(x, y, dir,group,tankFrame);
    }

    @Override
    public BaseBullet reateBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new RectBullet(x, y, dir, group, tankFrame);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new RectExplode(x, y, tankFrame);
    }
}

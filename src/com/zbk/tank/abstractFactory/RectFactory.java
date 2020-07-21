package com.zbk.tank.abstractFactory;

import com.zbk.tank.Dir;
import com.zbk.tank.GameModel;
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
    public BaseTank createTank(int x, int y, Dir dir, Group group, GameModel gm) {
        return new RectTank(x, y, dir,group,gm);
    }

    @Override
    public BaseBullet reateBullet(int x, int y, Dir dir, Group group, GameModel gm) {
        return new RectBullet(x, y, dir, group, gm);
    }

    @Override
    public BaseExplode createExplode(int x, int y, GameModel gm) {
        return new RectExplode(x, y, gm);
    }
}

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
    public BaseTank createTank(int x, int y, Dir dir, Group group, GameModel gm) {
        return new Tank(x, y, dir,group,gm);
    }

    @Override
    public BaseBullet reateBullet(int x, int y, Dir dir, Group group, GameModel gm) {
        return new Bullet(x, y, dir, group, gm);
    }

    @Override
    public BaseExplode createExplode(int x, int y, GameModel gm) {
        return new Explode(x, y, gm);
    }
}

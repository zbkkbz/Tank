package com.zbk.tank.abstractFactory;

import com.zbk.tank.Dir;
import com.zbk.tank.Group;
import com.zbk.tank.TankFrame;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-10 01:21
 **/
public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame);
    public abstract BaseBullet reateBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame);
    public abstract BaseExplode createExplode(int x, int y, TankFrame tankFrame);

}

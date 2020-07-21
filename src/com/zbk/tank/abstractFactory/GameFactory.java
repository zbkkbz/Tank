package com.zbk.tank.abstractFactory;

import com.zbk.tank.Dir;
import com.zbk.tank.GameModel;
import com.zbk.tank.Group;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-10 01:21
 **/
public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, GameModel gm);
    public abstract BaseBullet reateBullet(int x, int y, Dir dir, Group group, GameModel gm);
    public abstract BaseExplode createExplode(int x, int y, GameModel gm);

}

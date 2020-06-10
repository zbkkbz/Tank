package com.zbk.tank.abstractFactory;

import java.awt.*;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-10 01:12
 **/
public abstract class BaseBullet {


    public abstract void paint(Graphics g);

    public abstract void collideWith(BaseTank baseTank);
}

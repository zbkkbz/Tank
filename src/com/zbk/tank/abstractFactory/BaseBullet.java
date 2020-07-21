package com.zbk.tank.abstractFactory;

import com.zbk.tank.GameObject;
import com.zbk.tank.Group;

import java.awt.*;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-10 01:12
 **/
public abstract class BaseBullet extends GameObject {


    public abstract Group getGroup();

    public abstract Rectangle getRect();

    public abstract void die();
}

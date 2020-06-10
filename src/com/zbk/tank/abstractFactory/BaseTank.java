package com.zbk.tank.abstractFactory;

import com.zbk.tank.Dir;
import com.zbk.tank.Group;
import com.zbk.tank.TankFrame;

import java.awt.*;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-10 00:54
 **/
public abstract class BaseTank {
    public Rectangle rect = new Rectangle();
    public Group group = Group.BAD;
    public boolean live = true;
    public int x, y;



    public abstract void paint(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Group getGroup(){
        return group;
    }

    public void die() {
        live = false;
    }
}

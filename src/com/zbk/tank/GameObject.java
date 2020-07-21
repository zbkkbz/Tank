package com.zbk.tank;

import java.awt.*;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-07-08 02:18
 */
public abstract class GameObject {
    protected int x, y;

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

    public abstract void paint(Graphics g);
}

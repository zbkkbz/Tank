package com.zbk.tank.abstractFactory;

import com.zbk.tank.*;

import java.awt.*;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-10 00:54
 **/
public abstract class BaseTank extends GameObject {

    public Rectangle rect = new Rectangle();
    public Group group = Group.BAD;
    public boolean live = true;
    protected int previousX, previousY;
    protected Dir dir = Dir.DOWN;

    //moving是true的时候,才表示在移动
    protected boolean moving = true;


    public int getPreviousX() {
        return previousX;
    }

    public void setPreviousX(int previousX) {
        this.previousX = previousX;
    }

    public int getPreviousY() {
        return previousY;
    }

    public void setPreviousY(int previousY) {
        this.previousY = previousY;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group g) {
        this.group = g;
    }

    public void die() {
        live = false;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public abstract GameModel getGm();
}

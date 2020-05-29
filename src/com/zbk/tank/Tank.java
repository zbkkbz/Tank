package com.zbk.tank;/**
 * @author ZBK
 * @date 2020/5/28 - 11:22
 */

import java.awt.*;

/**
 * @program: Tank
 * @description:
 * @author: Zbk
 * @create: 2020-05-28 11:22
 **/
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;
    //moving是true的时候,才表示在移动
    private boolean moving = false;
    private TankFrame tankFrame = null;
    public static final int WIDTH=ResourceMgr.tankL.getWidth(), HEIGHT = ResourceMgr.tankL.getHeight();

    public Tank(int x, int y, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        this(x, y, tankFrame);
        this.dir = dir;
    }

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

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        switch (dir){
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
        }
        move();
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private void move() {
        if (!moving) return;

        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tankFrame.bulletList.add(new Bullet(bX, bY, dir, tankFrame));
    }
}

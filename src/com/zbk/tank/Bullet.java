package com.zbk.tank;/**
 * @author ZBK
 * @date 2020/5/28 - 23:57
 */

import java.awt.*;

/**
 * @program: Tank
 *
 * @description:
 *
 * @author: Zbk
 *
 * @create: 2020-05-28 23:57
 **/
public class Bullet {
    private static final int SPEED = 30;
    public static final int WIDTH=ResourceMgr.bulletD.getWidth(), HEIGHT = ResourceMgr.bulletD.getHeight();
    private int x,y;
    private Dir dir;
    private boolean live = true;
    private TankFrame tankFrame;

    public Bullet(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g){
        if (!live)
            tankFrame.bulletList.remove(this);
        switch (dir){
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }

        move();
    }

    private void move() {
        switch (dir){
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
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT)
            live = false;
    }

    public void collideWith(Tank tank) {
        //这个是创建一个矩形,首先拿到这个bullet所在的矩形
        Rectangle bulletRect = new Rectangle(x, y, WIDTH, HEIGHT);
        //拿到tank所在的矩形
        Rectangle tankRect = new Rectangle(tank.getX(),tank.getY(), Tank.WIDTH,Tank.HEIGHT);

        //判断两个矩形是否有相交的地方
        if (bulletRect.intersects(tankRect)){
            tank.die();
            this.die();
        }
    }

    private void die() {
        live = false;
    }
}

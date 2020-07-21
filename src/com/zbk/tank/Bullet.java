package com.zbk.tank;/**
 * @author ZBK
 * @date 2020/5/28 - 23:57
 */

import com.zbk.tank.abstractFactory.BaseBullet;

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
public class Bullet extends BaseBullet {
    private static final int SPEED = 30;
    public static final int WIDTH=ResourceMgr.bulletD.getWidth(), HEIGHT = ResourceMgr.bulletD.getHeight();
    private Dir dir;
    private boolean live = true;
    private GameModel gm;
    private Group group = Group.BAD;
    Rectangle rect = new Rectangle();
    private int bulletWidth = WIDTH;
    private int bulletHeight = HEIGHT;

    public Group getGroup() {
        return group;
    }

    @Override
    public Rectangle getRect() {
        return rect;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Bullet(int x, int y, Dir dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.group = group;
        this.dir = dir;
        this.gm = gm;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
        gm.add(this);
    }

    public Bullet(int x, int y, Dir dir, Group group, GameModel gm, int bulletWidth, int bulletHeight) {
        this(x,y,dir,group,gm);
        this.bulletWidth = bulletWidth;
        this.bulletHeight = bulletHeight;
        rect.width = bulletWidth;
        rect.height = bulletHeight;
    }

    public int getBulletWidth() {
        return bulletWidth;
    }

    public void setBulletWidth(int bulletWidth) {
        this.bulletWidth = bulletWidth;
    }

    public int getBulletHeight() {
        return bulletHeight;
    }

    public void setBulletHeight(int bulletHeight) {
        this.bulletHeight = bulletHeight;
    }

    @Override
    public void paint(Graphics g){
        if (!live)
            gm.remove(this);
        switch (dir){
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y,  null);
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

        rect.x = this.x;
        rect.y = this.y;

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT)
            live = false;
    }

    public void die() {
        live = false;
    }
}

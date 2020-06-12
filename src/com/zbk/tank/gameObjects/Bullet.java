package com.zbk.tank;/**
 * @author ZBK
 * @date 2020/5/28 - 23:57
 */

import com.zbk.tank.abstractFactory.BaseBullet;
import com.zbk.tank.abstractFactory.BaseTank;

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
    private int x,y;
    private Dir dir;
    private boolean live = true;
    private TankFrame tankFrame;
    private Group group = Group.BAD;
    Rectangle rect = new Rectangle();
    private int bulletWidth = WIDTH;
    private int bulletHeight = HEIGHT;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.group = group;
        this.dir = dir;
        this.tankFrame = tankFrame;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
        tankFrame.bulletList.add(this);
    }

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tankFrame, int bulletWidth, int bulletHeight) {
        this(x,y,dir,group,tankFrame);
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
            tankFrame.bulletList.remove(this);
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

    public void collideWith(BaseTank tank) {
        if (this.group == tank.getGroup())
            return;

        //TODO 最好要用一个rect来记录位置,这样就可以减少垃圾回收器工作
       /* //这个是创建一个矩形,首先拿到这个bullet所在的矩形
        Rectangle bulletRect = new Rectangle(x, y, WIDTH, HEIGHT);
        //拿到tank所在的矩形
        Rectangle tankRect = new Rectangle(tank.getX(),tank.getY(), Tank.WIDTH,Tank.HEIGHT);*/

        //判断两个矩形是否有相交的地方
        if (rect.intersects(tank.rect)){
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;

            tankFrame.explodes.add(tankFrame.factory.createExplode(x, y, tankFrame));
        }
    }

    private void die() {
        live = false;
    }
}

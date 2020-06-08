package com.zbk.tank;/**
 * @author ZBK
 * @date 2020/5/28 - 11:22
 */

import com.zbk.tank.fireStragety.AllDirFire;
import com.zbk.tank.fireStragety.DefaultFire;
import com.zbk.tank.fireStragety.FireStragety;
import com.zbk.tank.fireStragety.SuperSingleFire;

import java.awt.*;
import java.util.Random;

/**
 * @program: Tank
 * @description:
 * @author: Zbk
 * @create: 2020-05-28 11:22
 **/
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    //moving是true的时候,才表示在移动
    private boolean moving = true;
    private TankFrame tankFrame = null;
    public static final int WIDTH=ResourceMgr.goodTankU.getWidth(), HEIGHT = ResourceMgr.goodTankU.getHeight();
    private boolean live = true;
    private Random random = new Random();
    private Group group = Group.BAD;
    Rectangle rect = new Rectangle();

    public Tank(int x, int y,Group group, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.group = group;
        this.tankFrame = tankFrame;

        rect.x = this.x;
        rect.y = this.y;
        rect.height = HEIGHT;
        rect.width = WIDTH;
    }

    public Tank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this(x, y, group, tankFrame);
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {
        if (!live) tankFrame.enemies.remove(this);

        switch (dir){
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
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

        //当是bad tank,那每次move就有1/10的概率射击
        if (this.group == Group.BAD && random.nextInt(10) > 8){
            if (random.nextInt(100) > 90)
                this.fire(new AllDirFire());
            else
                this.fire(new DefaultFire());
        }

        if (this.group == Group.BAD && random.nextInt(100) > 95){
            randomDir();
        }

        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;

    }

    private void boundsCheck() {
        if (x < 0) x = 0;
        else if (y < 0) y = 0;
        else if (x > TankFrame.GAME_WIDTH - Tank.WIDTH) x = TankFrame.GAME_WIDTH - Tank.WIDTH;
        else if (y > TankFrame.GAME_HEIGHT - Tank.HEIGHT) y = TankFrame.GAME_HEIGHT-Tank.HEIGHT;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire(FireStragety fireStragety) {

            fireStragety.fireWay(this);

    }

    public void die() {
        live = false;
    }

    public TankFrame getTankFrame() {
        return tankFrame;
    }
}

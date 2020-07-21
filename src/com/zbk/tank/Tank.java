package com.zbk.tank;

import com.zbk.tank.abstractFactory.BaseTank;
import com.zbk.tank.fireStragety.AllDirFire;
import com.zbk.tank.fireStragety.DefaultFire;
import com.zbk.tank.fireStragety.FireStragety;

import java.awt.*;
import java.util.Random;

/**
 * @program: Tank
 * @description:
 * @author: Zbk
 * @create: 2020-05-28 11:22
 **/
public class Tank extends BaseTank {

    public static final int WIDTH = ResourceMgr.goodTankU.getWidth(), HEIGHT = ResourceMgr.goodTankU.getHeight();
    private static final int SPEED = 5;
    private final Random random = new Random();
    private GameModel gm;

    public Tank(int x, int y, Group group, GameModel gm) {
        super();
        this.x = x;
        this.y = y;
        this.group = group;
        this.gm = gm;

        rect.x = this.x;
        rect.y = this.y;
        rect.height = HEIGHT;
        rect.width = WIDTH;
    }

    public Tank(int x, int y, Dir dir, Group group, GameModel gm) {
        this(x, y, group, gm);
        this.dir = dir;
    }

    public GameModel getGm() {
        return gm;
    }

    public void setGm(GameModel gm) {
        this.gm = gm;
    }

    @Override
    public void paint(Graphics g) {
        if (!live) gm.remove(this);

        switch (dir) {
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


    private void move() {

        previousX = x;
        previousY = y;

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
        if (this.group == Group.BAD && random.nextInt(10) > 8) {
            if (random.nextInt(100) > 90)
                this.fire(new AllDirFire());
            else
                this.fire(new DefaultFire());
        }

        if (this.group == Group.BAD && random.nextInt(100) > 95) {
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
        else if (y > TankFrame.GAME_HEIGHT - Tank.HEIGHT) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire(FireStragety fireStragety) {

        // fireStragety.fireWay(this);
        int bX = x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        if (group == Group.BAD) {
            gm.add(new Bullet(bX, bY, dir, Group.BAD, gm));
        } else {
            gm.add(GameModel.factory.reateBullet(bX, bY, dir, Group.GOOD, gm));
        }
    }

}

package com.zbk.tank.abstractFactory;/**
 * @author ZBK
 * @date 2020/5/28 - 11:22
 */

import com.zbk.tank.*;
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
public class RectTank extends BaseTank {
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    //moving是true的时候,才表示在移动
    private boolean moving = true;
    private  GameModel gm;
    public static final int WIDTH= ResourceMgr.goodTankU.getWidth(), HEIGHT = ResourceMgr.goodTankU.getHeight();
    private boolean live = true;
    private Random random = new Random();
    private Group group = Group.BAD;
    public Rectangle rect = new Rectangle();

    public RectTank(int x, int y, Group group, GameModel gm) {
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

    public RectTank(int x, int y, Dir dir, Group group, GameModel gm) {
        this(x, y, group, gm);
        this.dir = dir;
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

    @Override
    public void paint(Graphics g) {
        if (!live) gm.remove(this);

        Color c = g.getColor();
        g.setColor(group == Group.GOOD ? Color.RED : Color.YELLOW);
        g.fillRect(x, y, 40, 40);
        g.setColor(c);

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
        else if (x > TankFrame.GAME_WIDTH - RectTank.WIDTH) x = TankFrame.GAME_WIDTH - RectTank.WIDTH;
        else if (y > TankFrame.GAME_HEIGHT - RectTank.HEIGHT) y = TankFrame.GAME_HEIGHT- RectTank.HEIGHT;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire(FireStragety fireStragety) {

           // fireStragety.fireWay(this);
        int bX = x + RectTank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = y + RectTank.HEIGHT/2 - Bullet.HEIGHT/2;
        if (group == Group.BAD){
            gm.add(new Bullet(bX, bY, dir, Group.BAD, gm));
        }else {
            gm.add(gm.factory.reateBullet(bX, bY, dir, Group.GOOD,gm));
        }
    }

    public void die() {
        live = false;
    }

    @Override
    public GameModel getGm() {
        return gm;
    }

}

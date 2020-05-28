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
    private static final int SPEED = 10;
    private static final int WIDTH=30, HEIGHT = 30;
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
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x, y, WIDTH,HEIGHT);
        g.setColor(c);

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
            case UL:
                y -= SPEED;
                x -= SPEED;
                break;
            case UR:
                y -= SPEED;
                x += SPEED;
                break;
            case DL:
                y += SPEED;
                x -= SPEED;
                break;
            case DR:
                y += SPEED;
                x += SPEED;
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT)
            live = false;
    }
}

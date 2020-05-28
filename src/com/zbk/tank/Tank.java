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
    private Dir dir = Dir.DEFAULT;
    private static final int SPEED = 10;

    public Tank(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Tank(int x, int y, Dir dir) {
        this(x, y);
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
        g.fillRect(x, y, 50, 50);
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
            default:
                break;
        }
    }
}

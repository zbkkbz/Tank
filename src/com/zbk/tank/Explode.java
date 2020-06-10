package com.zbk.tank;/**
 * @author ZBK
 * @date 2020/5/28 - 23:57
 */

import com.zbk.tank.abstractFactory.BaseExplode;

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
public class Explode extends BaseExplode {
    private static final int SPEED = 30;
    public static final int WIDTH=ResourceMgr.explodes[0].getWidth(), HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int x,y;
    private boolean live = true;
    private TankFrame tankFrame;

    private int step = 0;

    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    @Override
    public void paint(Graphics g){

        g.drawImage(ResourceMgr.explodes[step++],x ,y,null);

        if (step >= ResourceMgr.explodes.length){
            tankFrame.explodes.remove(this);
        }
    }
}


package com.zbk.tank.abstractFactory;

import com.zbk.tank.GameModel;
import com.zbk.tank.ResourceMgr;
import com.zbk.tank.TankFrame;

import java.awt.*;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-10 01:37
 **/
public class RectExplode extends BaseExplode {
    private static final int SPEED = 30;
    public static final int WIDTH= ResourceMgr.explodes[0].getWidth(), HEIGHT = ResourceMgr.explodes[0].getHeight();
    private boolean live = true;
    private GameModel gm;

    private int step = 0;

    public RectExplode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
    }

    @Override
    public void paint(Graphics g){

        //g.drawImage(ResourceMgr.explodes[step++],x ,y,null);
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10*step, 10*step);
        step++;

        if (step >= 15){
            gm.remove(this);
        }
        g.setColor(c);
    }

}

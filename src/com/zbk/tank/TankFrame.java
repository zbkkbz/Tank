package com.zbk.tank;/**
 * @author ZBK
 * @date 2020/5/27 - 23:12
 */

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Tank
 *
 * @description:
 *
 * @author: Zbk
 *
 * @create: 2020-05-27 23:12
 **/
public class TankFrame extends Frame {

   Tank tank = new Tank(200, 200, this);
   List<Bullet> bulletList = new ArrayList();
   static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    public TankFrame() throws HeadlessException {
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("tank");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("bullet num:" + bulletList.size(), 10, 60);
        tank.paint(g);

        //这里使用iterator的话会出现correntmodificationException
        //使用iterator遍历的时候,不能删除遍历list里面正在便利的对象
        for (int i = 0; i < bulletList.size(); i++){
            bulletList.get(i).paint(g);
        }
    }

    class MyKeyListener extends KeyAdapter{
        boolean bU = false;
        boolean bD = false;
        boolean bL = false;
        boolean bR = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    tank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bL && !bR && !bU && !bD)
                tank.setMoving(false);
            else
                tank.setMoving(true);

            if (bL) tank.setDir(Dir.LEFT);
            else if (bR) tank.setDir(Dir.RIGHT);
            else if (bU) tank.setDir(Dir.UP);
            else if (bD) tank.setDir(Dir.DOWN);
        }
    }
}

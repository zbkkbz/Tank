package com.zbk.tank;/**
 * @author ZBK
 * @date 2020/5/27 - 23:12
 */

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

    int x = 200, y=200;
    MyKeyListener myKeyListener = new MyKeyListener();
    public TankFrame() throws HeadlessException {
        setSize(800,600);
        setResizable(false);
        setTitle("tank");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        addKeyListener(myKeyListener);
    }

    @Override
    public void paint(Graphics g) {
        if (myKeyListener.bL)
            x -= 10;
        if (myKeyListener.bR)
            x += 10;
        if (myKeyListener.bU)
            y -= 10;
        if (myKeyListener.bD)
            y += 10;
        g.fillRect(x, y, 50, 50);

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
                default:
                    break;
            }
        }
    }
}

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
    Dir dir = Dir.DEFAULT;
    private static final int SPEED = 10;
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


        addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
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
            default:
                break;
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
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (bL && bU) dir = Dir.UL;
            else if (bL && bD) dir = Dir.DL;
            else if (bR && bU) dir = Dir.UR;
            else if (bR && bD) dir = Dir.DR;
            else if (bL) dir = Dir.LEFT;
            else if (bR) dir = Dir.RIGHT;
            else if (bU) dir = Dir.UP;
            else if (bD) dir = Dir.DOWN;
            else dir = Dir.DEFAULT;
        }

    }
}

package com.zbk;

import com.zbk.tank.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        int initalTankCOunt = Integer.parseInt((String)PropertyMgr.get("initTankCount")) ;

        //初始化敌方坦克
        for (int i =0; i<initalTankCOunt; i++){
            tankFrame.enemies.add(tankFrame.factory.createTank(50 + i*80, 200, Dir.DOWN, Group.BAD, tankFrame));
        }

        while (true){
            Thread.sleep(50);
            tankFrame.repaint();

        }
    }
}

package com.zbk;

import com.zbk.tank.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();


        while (true){
            Thread.sleep(50);
            tankFrame.repaint();

        }
    }
}

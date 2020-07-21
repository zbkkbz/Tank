package com.zbk.tank;

import com.zbk.tank.abstractFactory.DefaultFactory;
import com.zbk.tank.abstractFactory.GameFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-16 02:09
 **/
public class GameModel {
    public static final GameFactory factory = new DefaultFactory();
    Tank tank = new Tank(200, 400, Group.GOOD, this);
    private List<GameObject> gameObjects = new ArrayList<>();
    private ColliderChain colliderChain = ColliderChain.getColliderChain();


    public GameModel() {
        int initalTankCOunt = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

        //初始化敌方坦克
        for (int i = 0; i < initalTankCOunt; i++) {
            add(factory.createTank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    public void add(GameObject go) {
        gameObjects.add(go);
    }

    public void remove(GameObject go) {
        gameObjects.remove(go);
    }

    public Tank getMyTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.white);
        g.setColor(c);
        tank.paint(g);
        //这里使用iterator的话会出现correntmodificationException
        //使用iterator遍历的时候,不能删除遍历list里面正在便利的对象
        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }

        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = i + 1; j < gameObjects.size(); j++) {
                colliderChain.collide(gameObjects.get(i), gameObjects.get(j));


            }
        }
    }
}

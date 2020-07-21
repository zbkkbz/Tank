package com.zbk.tank.cor;

import com.zbk.tank.GameObject;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-07-14 01:21
 **/
public interface Collider {
    boolean collide(GameObject o1, GameObject o2);

}

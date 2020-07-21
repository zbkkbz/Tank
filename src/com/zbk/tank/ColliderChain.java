package com.zbk.tank;

import com.zbk.tank.cor.Collider;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-07-21 01:32
 **/
public class ColliderChain implements Collider{
    private static ColliderChain INSTANCE = new ColliderChain();
    private static List<Collider> colliders ;

    private ColliderChain(){
        colliders = new LinkedList<>();
        String collidersString = (String) PropertyMgr.prop.get("colliders");
        String[] collidersArray = collidersString.split(",");
        Arrays.stream(collidersArray).forEach(collider -> {
            try {
                Class<? extends Collider> colliderClazz = (Class<Collider>) Class.forName(collider);
                colliders.add(colliderClazz.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static ColliderChain getColliderChain(){
        return INSTANCE;
    }

    public void add(Collider c){
        colliders.add(c);
    }


    public boolean collide(GameObject o1, GameObject o2) {
        boolean isAnyColliderValid = colliders.stream().anyMatch(collider -> collider.collide(o1, o2));
        return isAnyColliderValid;
    }
}

package com.zbk.tank;

import com.zbk.tank.cor.Collider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertyMgr {
    static Properties prop = new Properties();

    //改造单例
    private PropertyMgr() {
    }

    static {
        try {
            prop.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config/TankProperty"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
        if (prop == null) return null;
        return prop.get(key);
    }

    public static void main(String[] args) {
        /*Object initTankCount = PropertyMgr.get("initTankCount");
        System.out.println(initTankCount);*/
        String colliders =(String) PropertyMgr.get("colliders");
        String[] colliderArray = colliders.split(",");
        List<Collider> colliderList = new ArrayList<>();
        Arrays.stream(colliderArray).forEach(collider -> {
            try {
                Class<?> clazz = Class.forName(collider);
                Collider o = (Collider)clazz.newInstance();
                colliderList.add(o);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        });
    }
}

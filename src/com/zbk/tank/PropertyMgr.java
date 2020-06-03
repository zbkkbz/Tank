package com.zbk.tank;

import java.io.IOException;
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
        Object initTankCount = PropertyMgr.get("initTankCount");
        System.out.println(initTankCount);

    }
}

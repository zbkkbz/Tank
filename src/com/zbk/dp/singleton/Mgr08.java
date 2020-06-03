package com.zbk.dp.singleton;

/**
 * @program: Tank
 * @description: 解决线程同步, 还可以防止反序列化
 * @author: Des
 * @create: 2020-06-03 13:42
 **/
public enum Mgr08 {
    INSTANCE;

    public void m(){
        //业务方法
    }

    public static void main(String[] args) {
        //可以这么调用
        Mgr08.INSTANCE.m();
    }
}

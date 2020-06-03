package com.zbk.dp.singleton;

/**
 * @program: Tank
 * @description: 与01没区别, 换种写法
 * @author: Des
 * @create: 2020-06-02 02:11
 **/
public class Mgr02 {
    private static final Mgr02 INSTANCE;
    static {
        INSTANCE = new Mgr02();
    }
    private Mgr02(){}

    public static Mgr02 getInstance(){
        return INSTANCE;
    }
}

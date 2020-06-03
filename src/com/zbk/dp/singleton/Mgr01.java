package com.zbk.dp.singleton;

/**
 * @program: Tank
 * @description: Eager Singleton饿汉式
 * 类加载到内存后,就实例化一个单例,JVM保证线程安全
 * 简单实用,推荐使用!
 * 唯一缺点:    不管用到与否,类装载时,就会实例化(你不用,实例化她干嘛)
 * @author: Des
 * @create: 2020-06-02 01:56
 **/
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();
    private Mgr01(){}
    public void m(){

    }
    public static Mgr01 getInstance(){return INSTANCE;}

    public static void main(String[] args) {
        Mgr01 instance = Mgr01.getInstance();
        instance.m();
    }
}

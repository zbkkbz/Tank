package com.zbk.dp.singleton;

/**
 * @program: Tank
 * @description: 静态内部类方式
 * JVM保证单例
 * 在加载外部类的时候,不会加载内部类进内存,这样就可以实现懒加载
 * @author: Des
 * @create: 2020-06-03 11:22
 **/
public class Mgr07 {
    private Mgr07() {
    }

    private static class Mgr07Holder {
        private static final Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance(){
        return Mgr07Holder.INSTANCE;
    }
}

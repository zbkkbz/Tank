package com.zbk.dp.singleton;

/**
 * @program: Tank
 * @description: lazyLoading, double check
 * @author: Des
 * @create: 2020-06-04 00:52
 **/
public class Mgr06 {
    //注意这个volatile是为了防止指令重排的
    //如果没有volitile,有可能还没被初始化就被return出去去了
    public static volatile Mgr06 INSTANCE;

    private Mgr06() {
    }

    public Mgr06 getINSTANCE(){
        if (INSTANCE == null){
            synchronized (Mgr06.class){
                if (INSTANCE == null){
                    INSTANCE = new Mgr06();
                }

            }
        }
        return INSTANCE;
    }
}

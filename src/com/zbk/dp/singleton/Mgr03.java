package com.zbk.dp.singleton;

/**
 * @program: Tank
 * @description: lazy loading懒汉式
 * 虽然达到了按需初始化的要求,但是在多线程同时访问的时候可能会有线程安全问题
 * @author: Des
 * @create: 2020-06-03 01:36
 **/
public class Mgr03 {
    private static Mgr03 INSTANCE;

    public Mgr03() {
    }

    public static Mgr03 getInstance(){
        if (INSTANCE == null){
            try {
                Thread.sleep(3);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i<100; i++){
            new Thread(() -> {
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }
}

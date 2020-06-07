package com.zbk.dp.stragety;

import com.zbk.tank.T;

/**
 * @program: Tank
 * @description: Cat
 * @author: Des
 * @create: 2020-06-04 01:18
 **/
public class Cat implements Comparable<Cat> {
    int weitht, height;

    @Override
    public String toString() {
        return "Cat{" +
                "weitht=" + weitht +
                ", height=" + height +
                '}';
    }

    public Cat(int weitht, int height) {
        this.weitht = weitht;
        this.height = height;
    }

    @Override
    public int compareTo(Cat c) {
 
        if (this.weitht > c.weitht) return 1;
        else if (this.weitht < c.weitht) return -1;
        else return 0;
    }
}

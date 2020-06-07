package com.zbk.dp.stragety;

import java.util.Comparator;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-07 14:52
 **/
public class DogComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog o1, Dog o2) {
        if (o1.food > o2.food) return 1;
        if (o1.food < o2.food) return -1;
        return 0;
    }
}

package com.zbk.dp.stragety;

import java.util.Arrays;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-07 14:58
 **/
public class TestMain {
    public static void main(String[] args) {
        Dog[] dogs = {new Dog(1), new Dog(2), new Dog(3)};
        Sorter.sort(dogs, new DogComparator());
        System.out.println(Arrays.toString(dogs));
    }
}

package com.zbk.dp.stragety;

import java.util.Comparator;

/**
 * @program: Tank
 * @description:
 * @author: Des
 * @create: 2020-06-04 01:09
 **/
public class Sorter {
    //选择排序
    public static <T> void sort(T arr[], Comparator comparator){
        for (int i = 0; i < arr.length-1; i++){
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++){
                minIndex = comparator.compare(arr[minIndex], arr[j]) > 1 ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

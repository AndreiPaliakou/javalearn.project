package com.apaliakou.homework04.strategy.sorter.impl;

import com.apaliakou.homework04.strategy.sorter.SorterStrategy;

public class BubbleSort2 implements SorterStrategy {
    public int[] sortingMethod(int[] array) {
        verifyIfInvalid(array);
        System.out.println("It was called the sorting method of the \"BubbleSort2 class\" for executing.");
        System.out.print("The initial array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for(int a = 1; a < array.length; a++) {
                if(array[a-1] > array[a]) {
                    int x = array[a-1];
                    array[a-1] = array[a];
                    array[a] = x;
                }
            }
        }
        System.out.print("The sorted array: ");
        for (int y = 0; y < array.length; y++) {
            System.out.print(array[y] + "  ");
        }
        return array;
    }
}

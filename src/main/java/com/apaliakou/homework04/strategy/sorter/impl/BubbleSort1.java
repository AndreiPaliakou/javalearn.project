package com.apaliakou.homework04.strategy.sorter.impl;

import com.apaliakou.homework04.strategy.sorter.SorterStrategy;

public class BubbleSort1 implements SorterStrategy {
    public int[] sortingMethod(int[] array) {
        verifyIfInvalid(array);
        System.out.println("It was called the sorting method of the \"BubbleSort1 class\" for executing.");
        System.out.print("The initial array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        int a, b, swap;
        for (a = 0; a < array.length - 1; a++) {
            for (b = 0; b < array.length - a - 1; b++) {
                if (array[b] > array[b + 1]) {
                    swap = array[b + 1];
                    array[b + 1] = array[b];
                    array[b] = swap;
                }
            }
        }
        System.out.println();
        System.out.print("The sorted array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        return array;
    }
}

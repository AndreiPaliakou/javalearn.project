package com.apaliakou.homework04.strategy.sorter.impl;

import com.apaliakou.homework04.strategy.sorter.SorterStrategy;

public class SelectionSort implements SorterStrategy {

    public int[] sortingMethod(int[] array) {
        verifyIfInvalid(array);
        System.out.println("It was called the sorting method of the \"SelectionSort class\" for executing.");
        System.out.print("The initial array: ");
        for (int j : array) {
            System.out.print(j + "  ");
        }
        System.out.println();
        for (int left = 0; left < array.length; left++) {
            int minimumIndex = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minimumIndex]) {
                    minimumIndex = i;
                }
            }
            int t = array[left];
            array[left] = array[minimumIndex];
            array[minimumIndex] = t;
        }
        System.out.print("The sorted array: ");
        for (int y = 0; y < array.length; y++) {
            System.out.print(array[y] + "  ");
        }
        return array;
    }
}

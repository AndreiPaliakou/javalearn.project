package com.apaliakou.homework0901;

public class Main {
    public static void main(String[] args) {
        ArrayDataAndMethods initialArray = new ArrayDataAndMethods();
        initialArray.setInitialArray(new int[]{98, 44, 58, 0, 1004, 239, -20});
        System.out.println(initialArray + "\n");

        initialArray.figuresSumCount();

        initialArray.sort();
    }
}

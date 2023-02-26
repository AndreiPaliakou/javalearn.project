package com.apaliakou.homework04.strategy;

import com.apaliakou.homework04.strategy.sorter.impl.BubbleSort1;
import com.apaliakou.homework04.strategy.sorter.impl.BubbleSort2;
import com.apaliakou.homework04.strategy.sorter.impl.SelectionSort;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new BubbleSort1());
        context.executeStrategy(new int[]{45, 1, 56, 0, 189, 24, -45, -15});
        System.out.println("\n");
        context.setStrategy(new BubbleSort2());
        context.executeStrategy(new int[]{465, -4546, 343, 7777, -142654, 0, 2365274});
        System.out.println("\n");
        context.setStrategy(new SelectionSort());
        context.executeStrategy(new int []{324, -4857, -1291209, 0, 3478, 35});
    }
}
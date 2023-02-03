package com.apaliakou.homework04.strategy;

import com.apaliakou.homework04.strategy.sorter.SorterStrategy;

public class Context {
    SorterStrategy strategy;

    public Context() {
    }

    public void setStrategy (SorterStrategy strategy) {
        this.strategy = strategy;
    }

    public int[] executeStrategy(int[] array) {
        return strategy.sortingMethod(array);
    }
}

package com.apaliakou.homework04.strategy.sorter;

import com.apaliakou.homework04.strategy.exception.InvalidInputArrayException;

public interface SorterStrategy {

    String INVALID_INPUT_ARRAY_MESSAGE = "Error!!! The array was invalid!!!";

    int[] sortingMethod(int[] array);

    default void verifyIfInvalid(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            throw new InvalidInputArrayException(INVALID_INPUT_ARRAY_MESSAGE);
        }
    }
}

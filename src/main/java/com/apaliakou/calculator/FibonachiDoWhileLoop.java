package com.apaliakou.calculator;

public class FibonachiDoWhileLoop implements Fibonachi {

	@Override
	public int[] returnFibonachi(int n) {
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        int s = 2;
        do {
            array[s] = array[s-2] + array[s-1];
            s++;
        } while (s < n);

        return array;
	}

}

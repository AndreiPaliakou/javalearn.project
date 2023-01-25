package main.java.com.apaliakou.homework03.median;

import java.util.Arrays;

public class Median {
    private Median() {
    }

    public static int median(int[] array) {
        Arrays.sort(array);
        if (array.length % 2 != 0) {
            return array[array.length / 2];
        }
        return (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
    }

    public static double median(double[] sortedArray) {
        int approximateMiddle = sortedArray.length / 2;
        int result = 0;
        for (int x = 0; x < sortedArray.length; x++) {
            if ((sortedArray.length % 2 != 0) && (x == approximateMiddle)) {
                return sortedArray[approximateMiddle];
            } else if ((sortedArray.length % 2 == 0) && (x == (approximateMiddle) - 1)) {
                return sortedArray[0] = (sortedArray[x] + sortedArray[x + 1]) / 2;
            }
        }
        return result;
    }
}

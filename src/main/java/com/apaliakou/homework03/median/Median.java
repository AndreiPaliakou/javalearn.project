package main.java.com.apaliakou.homework03.median;

public class Median {
    private Median() {
    }

    public static int median(int[] array) {
        int approximateIntArrayMedian = array.length / 2;
        for (int x = 0; x < array.length; x++) {
            if (x <= approximateIntArrayMedian) {
                return array[approximateIntArrayMedian];
            }
        }
        return -1;
    }
        public static double median (double[] array) {
            int approximateDoubleArrayMedian = array.length / 2;
            for (int i = 0; i < array.length; i++) {
                if (i <= approximateDoubleArrayMedian) {
                    return array[approximateDoubleArrayMedian];
                }
            }
            return -1;
        }
    }

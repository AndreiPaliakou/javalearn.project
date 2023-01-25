package main.java.com.apaliakou.homework03.median;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] iValues = {110, 99, 88, 77, 66, 55, 120, 44, 22, 33};
        double[] dValues = {32.45, 10.78, 44.76, 10.10, 89.87, 34.12, 120.342, 46.45, 23.98, 33.76};

        System.out.println("An initial integer array:\t\t\t\t\t\t" + Arrays.toString(iValues));
        int medianIntResult = Median.median(iValues);
        System.out.println("The sorted initial integer array:\t\t\t\t" + Arrays.toString(iValues));
        System.out.println("The median value of the sorted integer array:\t" + medianIntResult + "\n");

        System.out.println("An initial double array:\t\t\t\t\t\t" + Arrays.toString(dValues));
        Arrays.sort(dValues);
        System.out.println("The sorted initial double array:\t\t\t\t" + Arrays.toString(dValues));
        double medianDoubleResult = Median.median(dValues);
        System.out.println("The median value of the sorted double array:\t" + medianDoubleResult);
    }
}
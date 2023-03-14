package com.apaliakou.homework0901;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayDataAndMethods {

    private int[] initialArray;

    public ArrayDataAndMethods() {
    }

    public void setInitialArray(int[] initialArray) {
        this.initialArray = initialArray;
    }

    @Override
    public String toString() {
        return "ArrayDataAndMethods{" +
                "initialArray=" + Arrays.toString(initialArray) +
                '}';
    }

    public void figuresSumCount() {
        for (int i = 0; i < initialArray.length; i++) {
            if (initialArray[i] >= 0) {
                int[] figuresIntArray = convertIntNumberToIntFigures(initialArray[i]);
                int temp = 0;
                for (int j = 0; j < figuresIntArray.length; j++) {
                    temp += figuresIntArray[j];
                }
                addCoupleToTheList(initialArray[i], temp);
            }

            if (initialArray[i] < 0) {
                int x = Math.abs(initialArray[i]);
                initialArray[i] = x;
                int[] figuresIntArray = convertIntNumberToIntFigures(initialArray[i]);
                int temp2 = 0;
                for (int k = 0; k < figuresIntArray.length; k++) {
                    temp2 += figuresIntArray[k];
                }
                temp2 = temp2 - 2 * figuresIntArray[0];
                initialArray[i] = -initialArray[i];
                addCoupleToTheList(initialArray[i], temp2);
            }
        }
        System.out.println("\n" + listOfCouples + "\n");
    }

    private int[] convertIntNumberToIntFigures(int currentItem) {
        String numberToString = String.valueOf(currentItem);
        System.out.print("String representation (including without '-'): " + Arrays.toString(numberToString.toCharArray()) + ". ");
        int[] figuresIntArray = Arrays.stream(numberToString.split("")).mapToInt(Integer::parseInt).toArray();
        System.out.print("Figures array (including without '-'): " + Arrays.toString(figuresIntArray) + ".\n");
        return figuresIntArray;
    }

    private void addCoupleToTheList(int currentItem, int currentTemp) {
        Couple couple = new Couple();
        couple.setNumber(currentItem);
        couple.setFiguresSum(currentTemp);
        listOfCouples.add(couple);
    }

    public void sort() {
        System.out.println("Before sorting: ");
        listOfCouples.forEach(System.out::println);
        listOfCouples.sort(Comparator.comparingInt(Couple::getFiguresSum));
        System.out.println("\nAfter sorting:");
        listOfCouples.forEach(System.out::println);

    }

    private List<Couple> listOfCouples = new ArrayList<>();

    public List<Couple> getListOfCouples() {
        return listOfCouples;
    }

    public void setListOfCouples(List<Couple> listOfCouples) {
        this.listOfCouples = listOfCouples;
    }

}

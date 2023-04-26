package com.apaliakou.homework1202.instreams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainInStreams {
    public static void main(String[] args) {
        ArrayList<Long> myArrayList = new ArrayList<>(List.of(new Long[]{11L, 22L, 33L, 44L}));
        StatisticServiceInStreamsImpl myObject = new StatisticServiceInStreamsImpl();
        System.out.println("The first List<Long>: \n" + myArrayList);

        long resultSum = myObject.countEvenNumbers(myArrayList);
        System.out.println("The even number sum: \n" + resultSum + "\n");

        ArrayList<Long> myArrayList2 = new ArrayList<>(List.of(new Long[]{4L, 2L, 1L, 3L}));
        System.out.println("The second List<Long>: \n" + myArrayList2);
        System.out.println("A sorted squares number List<Long>: \n" + myObject.calculateSquareOfDistinctNumbers(myArrayList2));

        List<String> myArrayList3 = new ArrayList<>(List.of(new String[]{"dentist", "WELDER", "doctor", "tiger"}));
        List<String> myArrayList4 = new ArrayList<>(List.of(new String[]{"first", "", "SECOND", "third", "kid", "cloud"}));
        Set<List<String>> mySet = new HashSet<>();
        mySet.add(myArrayList3);
        mySet.add(myArrayList4);
        System.out.println();
        System.out.println("An initial Set<List<String>>: " + mySet);

        System.out.println(myObject.groupStringsByLastLetter(mySet));
    }
}

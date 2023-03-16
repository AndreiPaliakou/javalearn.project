package com.apaliakou.homework0902;

import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        HashSet<String> set1 = new HashSet<>(List.of(new String[]{"Andrei", "Misha", "Sasha", "Petr"}));
        HashSet<String> set2 = new HashSet<>(List.of(new String[]{"Vanya", "Andrei", "Sergei", "Misha"}));

        HashSetUtility<String> myFirstSet = new HashSetUtility<>(set1);
        HashSetUtility<String> mySecondSet = new HashSetUtility<>(set2);

        System.out.println("The first HashSet: " + myFirstSet.getMySet());
        System.out.println("The second HashSet: " + mySecondSet.getMySet() + "\n");

        myFirstSet.union(myFirstSet.getMySet(), mySecondSet.getMySet());
        myFirstSet.intersection(myFirstSet.getMySet(), mySecondSet.getMySet());
        myFirstSet.minus(myFirstSet.getMySet(), mySecondSet.getMySet());
        myFirstSet.difference(myFirstSet.getMySet(), mySecondSet.getMySet());
    }
}



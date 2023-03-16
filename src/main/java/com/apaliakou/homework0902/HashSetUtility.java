package com.apaliakou.homework0902;

import com.apaliakou.homework0902.Exceptions.EmptySetException;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetUtility<T> {

    private HashSet<T> mySet;

    public HashSetUtility(HashSet<T> mySet) {
        this.mySet = mySet;
    }

    public HashSet<T> getMySet() {
        return mySet;
    }

    public void setMySet(HashSet<T> mySet) {
        this.mySet = mySet;
    }

    public void union(HashSet<T> set1, HashSet<T> set2) {
        checkHashSetOnEmpty(set1);
        checkHashSetOnEmpty(set2);
        ArrayList<T> newArray1 = new ArrayList<>(set1);
        ArrayList<T> newArray2 = new ArrayList<>(set2);
        HashSet<T> resultedHashSet = new HashSet<>();
        for (T value1 : newArray1) {
            for (T value2 : newArray2) {
                if (!value1.equals(value2)) {
                    resultedHashSet.add(value1);
                    resultedHashSet.add(value2);
                }
                resultedHashSet.add(value1);
            }
        }
        System.out.println("Union operation result: " + resultedHashSet);
    }

    public void intersection(HashSet<T> set1, HashSet<T> set2) {
        checkHashSetOnEmpty(set1);
        checkHashSetOnEmpty(set2);
        ArrayList<T> newArray1 = new ArrayList<>(set1);
        ArrayList<T> newArray2 = new ArrayList<>(set2);
        HashSet<T> resultedHashSet = new HashSet<>();
        for (T value1 : newArray1) {
            for (T value2 : newArray2) {
                if (value1.equals(value2)) {
                    resultedHashSet.add(value1);
                }
            }
        }
        if (resultedHashSet.size() == 0) {
            System.out.print("The intersections were not found! ");
        }
        System.out.println("Intersection operation result: " + resultedHashSet);
    }

    public void minus(HashSet<T> set1, HashSet<T> set2) {
        checkHashSetOnEmpty(set1);
        checkHashSetOnEmpty(set2);
        ArrayList<T> newArray1 = new ArrayList<>(set1);
        ArrayList<T> newArray2 = new ArrayList<>(set2);
        HashSet<T> resultedHashSet = new HashSet<>();
        for (T value1 : newArray1) {
            for (T value2 : newArray2) {
                if (!value1.equals(value2)) {
                    resultedHashSet.add(value1);
                }
                newArray2.forEach(resultedHashSet::remove);
            }
        }
        if (resultedHashSet.size() == 0) {
            System.out.print("There is no such items which exist in the first HashSet and does not exist in the second one! ");
        }
        System.out.println("Minus operation result: " + resultedHashSet);
    }

    public void difference(HashSet<T> set1, HashSet<T> set2) {
        checkHashSetOnEmpty(set1);
        checkHashSetOnEmpty(set2);
        ArrayList<T> newArray1 = new ArrayList<>(set1);
        ArrayList<T> newArray2 = new ArrayList<>(set2);
        HashSet<T> resultedHashSet = new HashSet<>();
        for (T value1 : newArray1) {
            for (T value2 : newArray2) {
                resultedHashSet.add(value1);
                resultedHashSet.add(value2);
                if (newArray1.contains(value2)) {
                    resultedHashSet.remove(value2);
                }
            }
        }
        if (resultedHashSet.size() == 0) {
            System.out.print("All the HashSets items are identical! ");
        }
        System.out.println("Difference operation result: " + resultedHashSet);
    }

    private void checkHashSetOnEmpty(HashSet<T> set) {
        if (set.size() == 0) {
            String EMPTY_SET_EXCEPTION = "The HashSet is empty! Fill in the HashSet!";
            throw new EmptySetException(EMPTY_SET_EXCEPTION);
        }
    }
}

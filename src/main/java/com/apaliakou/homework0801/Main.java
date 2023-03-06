package com.apaliakou.homework0801;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> object1 = new MyArrayList<>();
        object1.add("One");
        object1.add("Two");
        object1.add("Three");
        object1.add("Four");
        object1.add("Five");
        object1.add("Six");
        object1.add("Seven");
        object1.add("Eight");
        object1.add("Nine");
        System.out.println(object1);

        System.out.println("The amount of fulled cells: " + object1.size() + "\n");

        object1.add("Ten");
        object1.add("Eleven");
        object1.add("Twelve");
        object1.add("Thirteen");
        object1.add("Fourteen");
        object1.add("Fifteen");

        System.out.println(object1);

        System.out.println("The amount of fulled cells: " + object1.size() + "\n");
        object1.add(1, "NEW WORDS");
        System.out.println(object1 + "\n");

        System.out.println("The amount of fulled cells: " + object1.size() + "\n");
        object1.set(3, "NEW STRING");
        System.out.println(object1 + "\n");

        System.out.println("The amount of fulled cells: " + object1.size() + "\n");
        System.out.println(object1.get(14) + "\n");

        System.out.println(object1.indexOf("Four") + "\n");

        System.out.println(object1);
        System.out.println("The amount of fulled cells: " + object1.size() + "\n");

        System.out.println(object1.subList(2, 5));

        object1.addWithoutArrayExtension("THE TEXT");
        System.out.println(object1);

    }
}

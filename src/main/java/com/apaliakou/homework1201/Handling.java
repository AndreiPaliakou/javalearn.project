package com.apaliakou.homework1201;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Handling {

    public void handle(MyClass myObject) throws NoSuchFieldException, IllegalAccessException {
        Class<? extends MyClass> getMyClassInformation = myObject.getClass();
        for (Field field : getMyClassInformation.getDeclaredFields()) {
            if (field.isAnnotationPresent(ThisCodeSmells.class)) {
                ThisCodeSmells annotation = field.getAnnotation(ThisCodeSmells.class);
                field.setAccessible(true);
                try {
                    String newReviewer = annotation.reviewer();
                    field.set(myObject, newReviewer);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(myObject + "\n");
        System.out.println("Class name:\n\t" + myObject.getClass().getName() + "\n");
        System.out.println("Fields names:\n\t" + Arrays.toString(myObject.getClass().getDeclaredFields()) + "\n");
        System.out.println("Method name:\n\t" + Arrays.toString(myObject.getClass().getDeclaredMethods()) + "\n");

        Field[] list = myObject.getClass().getDeclaredFields();
        ArrayList<String> stringList = new ArrayList<>();
        for (Field field : list) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                stringList.add(((ThisCodeSmells) annotation).reviewer());
            }
        }
        System.out.println("The reviewers arraylist: " + stringList + "\n");

        counter(stringList);
    }

    private void counter(ArrayList<String> listOfAnnotations) {
        Map<String, Integer> reviewersNames = new HashMap<String, Integer>();
        for (int i = 0; i < listOfAnnotations.size(); i++) {
            String temp = listOfAnnotations.get(i);
            if (!reviewersNames.containsKey(temp)) {
                reviewersNames.put(temp, 1);
            } else {
                reviewersNames.put(temp, reviewersNames.get(temp) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : reviewersNames.entrySet()) {
            System.out.println("Reviewer = \t" + entry.getKey() + ".\tNumber of repetitions = " + entry.getValue() + ".");
        }
    }
}


package com.apaliakou.homework1201;

public class MyClass {

    @ThisCodeSmells(reviewer = "Alex")
    private String reviewer1;

    @ThisCodeSmells()
    private String reviewer2;

    @ThisCodeSmells(reviewer = "Petya")
    private String reviewer3;
    @ThisCodeSmells(reviewer = "Alex")
    private String reviewer4;

    @ThisCodeSmells(reviewer = "Andrei")
    private String reviewer5;

    private void myMethod() {
        System.out.println("The reviewer was assigned!!!");

    }

    @Override
    public String toString() {
        return "MyClass{" +
                "reviewer1='" + reviewer1 + '\'' +
                ", reviewer2='" + reviewer2 + '\'' +
                ", reviewer3='" + reviewer3 + '\'' +
                ", reviewer4='" + reviewer4 + '\'' +
                ", reviewer5='" + reviewer5 + '\'' +
                '}';
    }
}




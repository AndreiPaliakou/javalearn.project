package com.apaliakou.homework07;

public class ValidationSystem {


    public static void getValidator(Integer someValue) {
        new IntValidator().validate(someValue);
    }

    public static void getValidator(String someText) {
        new StringValidator().validate(someText);
    }
}

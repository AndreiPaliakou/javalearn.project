package com.apaliakou.homework07;

public class Main {
    public static void main(String[] args) {
        ValidationFactory validationFactory = new ValidationFactory();
        Validator integerValidator = validationFactory.validateInt(2);
        integerValidator.validate();
        Validator stringValidator = validationFactory.validateString("The text");
        stringValidator.validate();
    }
}

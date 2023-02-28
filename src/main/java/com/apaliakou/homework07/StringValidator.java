package com.apaliakou.homework07;

import com.apaliakou.homework07.exceptions.ValidationFailedException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator implements Validator<String> {

    @Override
    public void validate(String text) {
        if (!text.equals("")) {
            String substring = text.substring(0, 1);
            Pattern pattern = Pattern.compile("[A-Z]");
            Matcher matcher = pattern.matcher(substring);
            String VALIDATION_FAILED_EXCEPTION = "Sorry!!! The string first letter is not a capital letter!!!";
            if (matcher.find()) {
                System.out.println("The string validation was done successfully!!!");
            } else {
                throw new ValidationFailedException(VALIDATION_FAILED_EXCEPTION);
            }
        } else {
            String VALIDATION_FAILED_EXCEPTION = "Sorry!!! The string is empty!!!";
            throw new ValidationFailedException(VALIDATION_FAILED_EXCEPTION);
        }
    }
}

package com.apaliakou.homework07;

import com.apaliakou.homework07.exceptions.ValidationFailedException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationFactory {

    public Validator validateInt(Integer value) {

        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> templateArray = Arrays.asList(array);
        String VALIDATION_FAILED_EXCEPTION = "Sorry!!! This integer is not included in the template array!!!";
        if (templateArray.contains(value)) {
            return new IntegerValidator();
        } else {
            throw new ValidationFailedException(VALIDATION_FAILED_EXCEPTION);
        }
    }

    public Validator validateString(String text) {
        String substring = text.substring(0, 1);
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(substring);
        String VALIDATION_FAILED_EXCEPTION = "Sorry!!! The string first letter is not a capital letter!!!";
        if (matcher.find()) {
            return new StringValidator();
        } else {
            throw new ValidationFailedException(VALIDATION_FAILED_EXCEPTION);
        }
    }
}


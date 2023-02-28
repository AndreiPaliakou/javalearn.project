package com.apaliakou.homework07;

import com.apaliakou.homework07.exceptions.ValidationFailedException;

public class IntValidator implements Validator<Integer> {

    @Override
    public void validate(Integer value) {
        if (value != 0) {
            String VALIDATION_FAILED_EXCEPTION = "Sorry!!! This integer is not included in 1-10 range!!!";
            if (value >= 1 && value <= 10) {
                System.out.println("An integer validation was done successfully!!!");
            } else {
                throw new ValidationFailedException(VALIDATION_FAILED_EXCEPTION);
            }
        } else {
            String VALIDATION_FAILED_EXCEPTION = "Sorry!!! This value is null!!!";
            throw new ValidationFailedException(VALIDATION_FAILED_EXCEPTION);
        }
    }
}

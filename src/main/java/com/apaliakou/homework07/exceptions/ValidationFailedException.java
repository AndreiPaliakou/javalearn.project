package com.apaliakou.homework07.exceptions;

public class ValidationFailedException extends RuntimeException {

    public ValidationFailedException(String message) {
        super(message);
    }
}

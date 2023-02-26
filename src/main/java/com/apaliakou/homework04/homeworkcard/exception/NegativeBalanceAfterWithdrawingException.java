package com.apaliakou.homework04.homeworkcard.exception;

public class NegativeBalanceAfterWithdrawingException extends RuntimeException {

    public NegativeBalanceAfterWithdrawingException(String message) {
        super(message);
    }
}

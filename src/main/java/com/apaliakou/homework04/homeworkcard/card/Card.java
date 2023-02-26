package com.apaliakou.homework04.homeworkcard.card;

import com.apaliakou.homework04.homeworkcard.exception.NegativeInputException;
import java.math.BigDecimal;

public abstract class Card {
    protected static final String NEGATIVE_INPUT_MESSAGE = "It was a negative input value!!!";

    protected static final String NEGATIVE_BALANCE_MESSAGE = "The negative balance is not allowed!!! " +
            "The operation is forbidden!!!";

    private String holderName;
    private BigDecimal balance;

    public Card(String holderName, BigDecimal balance) {
        this.holderName = holderName;
        this.balance = balance;
    }

    public Card(String holderName) {
        this.holderName = holderName;
        this.balance = new BigDecimal("0");
    }

    public String getHolderName() {
        return this.holderName;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public Card addBalance(BigDecimal addSum) {
        verifyIfNegative(addSum);
        this.balance = this.balance.add(addSum);
        return this;
    }

    public Card withdrawBalance(BigDecimal withdrawSum) {
        verifyIfNegative(withdrawSum);
        this.balance = this.balance.subtract(withdrawSum);
        return this;
    }

    public BigDecimal currencyConverter(Double coefficientEnter) {
        BigDecimal coefficientConversion = new BigDecimal(coefficientEnter);
        verifyIfNegative(coefficientConversion);
        return balance.multiply(coefficientConversion);
    }

    protected boolean checkIfPositive(BigDecimal checkedSum) {
        return checkedSum.compareTo(new BigDecimal("0")) >= 0;
    }

    protected void verifyIfNegative(BigDecimal enteredSum) {
        if (enteredSum.compareTo(BigDecimal.ZERO) <= 0) {
            throw new NegativeInputException(NEGATIVE_INPUT_MESSAGE);
        }
    }
}



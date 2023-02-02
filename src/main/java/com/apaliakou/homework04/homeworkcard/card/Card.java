package com.apaliakou.homework04.homeworkcard.card;

import com.apaliakou.homework04.homeworkcard.exception.NegativeCoefficientInputException;
import com.apaliakou.homework04.homeworkcard.exception.NegativeSumInputException;
import java.math.BigDecimal;

public abstract class Card {
    protected static final String NEGATIVE_INPUT_SUM_MESSAGE = "It was a negative sum value!!!";
    protected static final String NEGATIVE_COEFFICIENT_INPUT_MESSAGE = "It was a negative currency " +
            "coefficient value!!!";
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
        checkInputSumForNegativity(addSum);
        this.balance = this.balance.add(addSum);
        return this;
    }

    public Card withdrawBalance(BigDecimal withdrawSum) {
        checkInputSumForNegativity(withdrawSum);
        this.balance = this.balance.subtract(withdrawSum);
        return this;
    }

    public BigDecimal currencyConverter(Double coefficientEnter) {
        checkCoefficientForNegativity(coefficientEnter);
        BigDecimal coefficientConversion = new BigDecimal(coefficientEnter);
        return balance.multiply(coefficientConversion);
    }

    protected boolean checkIfPositive(BigDecimal checkedSum) {
        return checkedSum.compareTo(new BigDecimal("0")) >= 0;
    }

    protected void checkInputSumForNegativity(BigDecimal enteredSum) {
        if (enteredSum.compareTo(BigDecimal.ZERO) <= 0) {
            throw new NegativeSumInputException(NEGATIVE_INPUT_SUM_MESSAGE);
        }
    }

    private void checkCoefficientForNegativity(Double enteredCoefficient) {
        if (enteredCoefficient <= 0) {
            throw new NegativeCoefficientInputException(NEGATIVE_COEFFICIENT_INPUT_MESSAGE);
        }
    }
}



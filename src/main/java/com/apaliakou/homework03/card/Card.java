package main.java.com.apaliakou.homework03.card;

import java.math.BigDecimal;

public class Card {
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

    public void setHolderName(String newHolderName) {
        this.holderName = newHolderName;
    }

    public void setBalance(BigDecimal newBalance) {
        this.balance = newBalance;
    }

    public Card addBalance(BigDecimal addSum) {
        if (checkIfPositive(addSum)) {
            this.balance = this.balance.add(addSum);
        } else {
            System.out.println("Enter the positive value!!!");
        }
        return this;
    }

    public Card withdrawBalance(BigDecimal withdrawSum) {
        if (checkIfPositive(withdrawSum)) {
            this.balance = this.balance.subtract(withdrawSum);
        } else {
            System.out.println("Enter the positive value!!!");
        }
        return this;
    }

    public BigDecimal currencyConverter(Double coefficientEnter) {
        BigDecimal coefficientConversion = new BigDecimal(coefficientEnter);
        boolean checking = coefficientConversion.compareTo(new BigDecimal("0")) < 0;
        if (checking) {
            System.out.println("Enter the positive value!!!");
            return balance;
        } else {
            return balance.multiply(coefficientConversion);
        }
    }

    private boolean checkIfPositive(BigDecimal checkedSum) {
        return checkedSum.compareTo(new BigDecimal("0")) > 0;
    }
}

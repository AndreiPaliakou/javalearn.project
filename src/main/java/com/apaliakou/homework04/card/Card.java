package main.java.com.apaliakou.homework04.card;

import java.math.BigDecimal;

public class Card {
    protected String holderName;
    protected BigDecimal balance;

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
            System.out.println("Warning!!! Enter the positive value!!!");
        }
        return this;
    }

    public Card withdrawBalance(BigDecimal withdrawSum) {
        if (checkIfPositive(withdrawSum)) {
            if (withdrawingResult(withdrawSum)) {
                this.balance = this.balance.subtract(withdrawSum);
            } else {
                this.balance = this.balance.subtract(withdrawSum);
                System.out.println("Attention!!! Now you have a negative debit card balance (debt)!!!");
            }
        } else {
            System.out.println("Warning!!! Enter the positive value for the drawing!!!");
        }
        return this;
    }

    public BigDecimal currencyConverter(Double coefficientEnter) {
        BigDecimal coefficientConversion = new BigDecimal(coefficientEnter);
        boolean checking = coefficientConversion.compareTo(new BigDecimal("0")) < 0;
        if (checking) {
            System.out.println("Warning!!! Enter the positive value!!!");
            return balance;
        } else {
            return balance.multiply(coefficientConversion);
        }
    }

    private boolean checkIfPositive(BigDecimal checkedSum) {
        return checkedSum.compareTo(new BigDecimal("0")) > 0;
    }

    private boolean withdrawingResult(BigDecimal checkedSum) {
        return balance.subtract(checkedSum.abs()).compareTo(new BigDecimal("0")) >= 0;
    }

    // THE INNER CLASS WAS CREATED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public class DebitCard {

        public DebitCard(BigDecimal balance) {
        }

        public DebitCard withdrawingOperationWithStop(BigDecimal withdrawSum) {
            if (checkIfPositive(withdrawSum)) {
                if (withdrawingResult(withdrawSum)) {
                    Card.this.balance = Card.this.balance.subtract(withdrawSum);
                } else {
                    System.out.println("Sorry!!! Your debit card balance does not has enough sum for " +
                            "the next drawing!!!");
                }
            } else {
                System.out.println("Warning!!! Enter the positive value for the drawing!!!");
            }
            return this;
        }
    }

    public class CreditCard {

        public CreditCard(BigDecimal balance) {
        }

        public CreditCard withdrawingOperationWithoutStop(BigDecimal withdrawSum) {
            if (checkIfPositive(withdrawSum)) {
                if (withdrawingResult(withdrawSum)) {
                    Card.this.balance = Card.this.balance.subtract(withdrawSum);
                } else {
                    Card.this.balance = Card.this.balance.subtract(withdrawSum);
                    System.out.println("Attention!!! Now your credit card balance is negative (the debt was done)!!!");
                }
            } else {
                System.out.println("Warning!!! Enter the positive value for the drawing!!!");
            }
            return this;
        }
    }
}



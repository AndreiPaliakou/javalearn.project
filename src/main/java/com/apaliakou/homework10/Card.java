package com.apaliakou.homework10;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicBoolean;

public class Card {

    private String cardName;
    private BigDecimal cardBalance;

    public static final AtomicBoolean flag = new AtomicBoolean(true);

    public Card(String cardName, BigDecimal cardBalance) {
        this.cardName = cardName;
        this.cardBalance = cardBalance;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public BigDecimal getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(BigDecimal cardBalance) {
        this.cardBalance = cardBalance;
    }

    public synchronized void add(BigDecimal addSum) {
        setCardBalance(getCardBalance().add(addSum));
        System.out.println(Thread.currentThread().getName() +
                ",\t\t add sum: \t\t" + addSum +
                ",\t\t current balance: \t" + this.cardBalance);
    }

    public synchronized void subtract(BigDecimal subtractSum) {
        setCardBalance(getCardBalance().subtract(subtractSum));
        System.out.println(Thread.currentThread().getName() +
                ",\t\t subtract sum: \t" + subtractSum +
                ",\t\t current balance: \t" + this.cardBalance);
    }
}

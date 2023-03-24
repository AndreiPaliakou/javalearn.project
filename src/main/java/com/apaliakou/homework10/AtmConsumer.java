package com.apaliakou.homework10;

import java.math.BigDecimal;

public class AtmConsumer extends Atm {

    private String subtractAtmName;

    public AtmConsumer(Card card, String subtractAtmName) {
        super(card);
        this.subtractAtmName = subtractAtmName;
    }

    public String getSubtractAtmName() {
        return subtractAtmName;
    }

    public void setSubtractAtmName(String subtractAtmName) {
        this.subtractAtmName = subtractAtmName;
    }

    public void operation(Card card, BigDecimal operationSum) {
        if (card.getCardBalance().compareTo(operationSum) < 0) {
            card.subtract(card.getCardBalance());
            Card.flag.set(false);
            System.out.println("Program is finished with thread: " + Thread.currentThread().getName());
        } else {
            card.subtract(operationSum);
        }
    }
}

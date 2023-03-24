package com.apaliakou.homework10;

import java.math.BigDecimal;

public class AtmProducer extends Atm {

    private String addAtmName;

    public AtmProducer(Card card, String addAtmName) {
        super(card);
        this.addAtmName = addAtmName;
    }

    public String getAddAtmName() {
        return addAtmName;
    }

    public void setAddAtmName(String addAtmName) {
        this.addAtmName = addAtmName;
    }

    public void operation(Card card, BigDecimal operationSum) {
        if (card.getCardBalance().add(operationSum).compareTo(new BigDecimal(1000)) > 0) {
            card.add(new BigDecimal(1000).subtract(card.getCardBalance()));
            Card.flag.set(false);
            System.out.println("Program is finished with thread: " + Thread.currentThread().getName());
        } else {
            card.add(operationSum);
        }
    }
}

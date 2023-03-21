package com.apaliakou.homework1001;

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

    public Atm operation(BigDecimal subtractSum) throws InterruptedException {
        BigDecimal result = getCard().getCardBalance().subtract(subtractSum);
        getCard().setCardBalance(result);
        System.out.println(getCard().getCardBalance() + "Method subtract");
        return this;
    }

    public void getAtmSubtractInfo() {
        System.out.println("Atm name - " + getSubtractAtmName() + ", card name - " +
                getCard().getCardName() + ", card balance - " + getCard().getCardBalance() + ".");
    }
}

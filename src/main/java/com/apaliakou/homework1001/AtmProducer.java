package com.apaliakou.homework1001;

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

    public Atm operation(BigDecimal addSum) {
        BigDecimal result = getCard().getCardBalance().add(addSum);
        getCard().setCardBalance(result);
        System.out.println(getCard().getCardBalance() + "Method add");
        return this;
    }

    public void getAtmAddInfo() {
        System.out.println("Atm name - " + getAddAtmName() + ", card name - " +
                getCard().getCardName() + ", card balance - " + getCard().getCardBalance() + ".");
    }


}

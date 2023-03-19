package com.apaliakou.homework1001;

import java.math.BigDecimal;

public class Card {

    private String cardName;
    private BigDecimal cardBalance;

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
        boolean lessThenZero = cardBalance.compareTo(new BigDecimal("0")) <= 0;
        boolean moreThenThousand = cardBalance.compareTo(new BigDecimal("1000")) >= 0;
        if (lessThenZero || moreThenThousand) {
            Thread.currentThread().interrupt();
        } else {
            this.cardBalance = cardBalance;
        }
    }
}

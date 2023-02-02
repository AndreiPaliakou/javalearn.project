package com.apaliakou.homework04.homeworkcard;

import com.apaliakou.homework04.homeworkcard.card.Card;
import java.math.BigDecimal;

public class Atm {

    private Card inputCard;

    public Atm(Card inputCard) {
        this.inputCard = inputCard;
    }

    public Card withdraw(BigDecimal withdrawSum) {
        return inputCard.withdrawBalance(withdrawSum);
    }

    public Card add(BigDecimal addSum) {
        return inputCard.addBalance(addSum);
    }

    public BigDecimal getCardBalance() {
        return inputCard.getBalance();
    }
}

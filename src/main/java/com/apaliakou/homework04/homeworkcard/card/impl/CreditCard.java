package com.apaliakou.homework04.homeworkcard.card.impl;

import com.apaliakou.homework04.homeworkcard.card.Card;
import java.math.BigDecimal;

public class CreditCard extends Card {

    public CreditCard(String holderName, BigDecimal balance) {
        super(holderName, balance);
    }

    public CreditCard(String holderName) {
        super(holderName);
    }

    @Override
    public Card withdrawBalance(BigDecimal withdrawSum) {
        checkInputSumForNegativity(withdrawSum);
        return super.withdrawBalance(withdrawSum);
    }


}

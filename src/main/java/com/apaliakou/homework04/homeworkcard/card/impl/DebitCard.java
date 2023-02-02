package com.apaliakou.homework04.homeworkcard.card.impl;

import com.apaliakou.homework04.homeworkcard.exception.NegativeBalanceAfterWithdrawingException;
import com.apaliakou.homework04.homeworkcard.card.Card;
import java.math.BigDecimal;

public class DebitCard extends Card {

    public DebitCard(String holderName, BigDecimal balance) {
        super(holderName, balance);
    }

    public DebitCard(String holderName) {
        super(holderName);
    }

    @Override
    public Card withdrawBalance(BigDecimal withdrawSum) {
        checkInputSumForNegativity(withdrawSum);
        checkNegativeBalance(withdrawSum);
        return super.withdrawBalance(withdrawSum);
    }

    private void checkNegativeBalance(BigDecimal withdrawSum) {
        if (!checkIfPositive(getBalance().subtract(withdrawSum))) {
            throw new NegativeBalanceAfterWithdrawingException(NEGATIVE_BALANCE_MESSAGE);
        }
    }
}

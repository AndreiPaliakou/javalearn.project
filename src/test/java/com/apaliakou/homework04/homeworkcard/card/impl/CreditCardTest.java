package com.apaliakou.homework04.homeworkcard.card.impl;

import com.apaliakou.homework04.homeworkcard.exception.NegativeCoefficientInputException;
import com.apaliakou.homework04.homeworkcard.exception.NegativeSumInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    private CreditCard visa;

    @BeforeEach
    void constructorFillingIn() {

        visa = new CreditCard("Misha", new BigDecimal("1000"));
    }

    @Test
    public void withdraw_OperationForCreditCard_CreditCardFinalBalance() {
        // given
        BigDecimal withdrawSumForCreditCard = BigDecimal.valueOf(300);
        BigDecimal expectedBalanceAfterDrawing = BigDecimal.valueOf(700);
        // when
        visa.withdrawBalance(withdrawSumForCreditCard);
        BigDecimal balanceAfterWithdraw = visa.getBalance();
        // then
        assertEquals(0, expectedBalanceAfterDrawing.compareTo(balanceAfterWithdraw));
    }

    @Test
    public void withdrawBalance_NegativeSumInput_Exception() {
        // given
        BigDecimal withdrawSumForCreditCard = BigDecimal.valueOf(-1200);
        String expectedMessage = "It was a negative sum value!!!";
        // when
        Exception exception = assertThrows(NegativeSumInputException.class, () -> {
            visa.withdrawBalance(withdrawSumForCreditCard);
        });
        String actualMessage = exception.getMessage();
        // then
        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void currencyConverter_NegativeCoefficientInput_Exception() {
        // given
        Double coefficientEnter = - 75.0;
        String expectedMessage = "It was a negative currency coefficient value!!!";
        // when
        Exception exception = assertThrows(NegativeCoefficientInputException.class, () -> {
            visa.currencyConverter(coefficientEnter);
        });
        String actualMessage = exception.getMessage();
        // then
        assertEquals(actualMessage, expectedMessage);
    }
}
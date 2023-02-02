package com.apaliakou.homework04.homeworkcard.card.impl;

import com.apaliakou.homework04.homeworkcard.card.Card;
import com.apaliakou.homework04.homeworkcard.exception.NegativeBalanceAfterWithdrawingException;
import com.apaliakou.homework04.homeworkcard.exception.NegativeCoefficientInputException;
import com.apaliakou.homework04.homeworkcard.exception.NegativeSumInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class DebitCardTest {

    private Card visaGold;

    @BeforeEach
    void constructorFillingIn() {
        visaGold = new DebitCard("Andrei", new BigDecimal("2000"));
    }

    @Test
    public void withdraw_OperationForDebitCard_DebitCardFinalBalance() {
        // given
        BigDecimal withdrawSumForDebitCard = BigDecimal.valueOf(1200);
        BigDecimal expectedBalanceAfterDrawing = BigDecimal.valueOf(800);
        // when
        visaGold.withdrawBalance(withdrawSumForDebitCard);
        BigDecimal balanceAfterWithdraw = visaGold.getBalance();
        // then
        assertEquals(0, expectedBalanceAfterDrawing.compareTo(balanceAfterWithdraw));
    }

    @Test
    public void withdraw_NegativeSumInput_Exception() {
        // given
        BigDecimal withdrawSumForDebitCard = BigDecimal.valueOf(-1200);
        String expectedMessage = "It was a negative sum value!!!";
        // when
        Exception exception = assertThrows(NegativeSumInputException.class, () -> {
            visaGold.withdrawBalance(withdrawSumForDebitCard);
        });
        String actualMessage = exception.getMessage();
        // then
        assertTrue(actualMessage.equals(expectedMessage));

    }

    @Test
    public void withdraw_NegativeBalanceAfterWithdrawing_Exception() {
        // given
        BigDecimal withdrawSumForDebitCard = BigDecimal.valueOf(3000);
        String expectedMessage = "The negative balance is not allowed!!! The operation is forbidden!!!";
        // when
        Exception exception = assertThrows(NegativeBalanceAfterWithdrawingException.class, () -> {
            visaGold.withdrawBalance(withdrawSumForDebitCard);
        });
        String actualMessage = exception.getMessage();
        // then
        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void currencyConverter_NegativeCoefficientInput_Exception() {
        // given
        Double coefficientEnter = - 75.0;
        String expectedMessage = "It was a negative currency coefficient value!!!";
        // when
        Exception exception = assertThrows(NegativeCoefficientInputException.class, () -> {
            visaGold.currencyConverter(coefficientEnter);
        });
        String actualMessage = exception.getMessage();
        // then
        assertEquals(actualMessage, expectedMessage);
    }
}
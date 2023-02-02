package com.apaliakou.homework04.homeworkcard;

import com.apaliakou.homework04.homeworkcard.card.Card;
import com.apaliakou.homework04.homeworkcard.card.impl.DebitCard;
import com.apaliakou.homework04.homeworkcard.card.impl.CreditCard;
import com.apaliakou.homework04.homeworkcard.exception.NegativeBalanceAfterWithdrawingException;
import com.apaliakou.homework04.homeworkcard.exception.NegativeInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class AtmTest {

    private Card superVisaGold;
    private Card megaVisaGold;

    @BeforeEach
    void create_TestObjects() {
        superVisaGold = new CreditCard("John", BigDecimal.valueOf(1000));
        megaVisaGold = new DebitCard("Denny", BigDecimal.valueOf(2000));
    }

    @Test
    void withdraw_OperationForAtmCreditCard_AtmCreditCardFinalBalance() {
        // given
        BigDecimal withdrawSumFromAtmCreditCard = BigDecimal.valueOf(1000);
        BigDecimal expectedBalanceAfterDrawing = BigDecimal.valueOf(0);
        // when
        superVisaGold.withdrawBalance(withdrawSumFromAtmCreditCard);
        BigDecimal balanceAfterWithdrawing = superVisaGold.getBalance();
        // then
        assertEquals(0, expectedBalanceAfterDrawing.compareTo(balanceAfterWithdrawing));
    }

    @Test
    void withdraw_OperationForAtmDebitCard_AtmDebitCardFinalBalance() {
        // given
        BigDecimal withdrawSumFromAtmDebitCard = BigDecimal.valueOf(2000);
        BigDecimal expectedBalanceAfterDrawing = BigDecimal.valueOf(0);
        // when
        megaVisaGold.withdrawBalance(withdrawSumFromAtmDebitCard);
        BigDecimal balanceAfterWithdrawing = megaVisaGold.getBalance();
        // then
        assertEquals(0, expectedBalanceAfterDrawing.compareTo(balanceAfterWithdrawing));
    }

    @Test
    void add_ForAtmCreditCard_AtmCreditCardFinalBalance() {
        // given
        BigDecimal addSumFromAtmCreditCard = BigDecimal.valueOf(1000);
        BigDecimal expectedBalanceAfterDrawing = BigDecimal.valueOf(2000);
        // when
        superVisaGold.addBalance(addSumFromAtmCreditCard);
        BigDecimal balanceAfterAdd = superVisaGold.getBalance();
        // then
        assertEquals(0, expectedBalanceAfterDrawing.compareTo(balanceAfterAdd));
    }

    @Test
    void add_ForAtmDebitCard_AtmDebitCardFinalBalance() {
        // given
        BigDecimal addSumFromAtmDebitCard = BigDecimal.valueOf(2000);
        BigDecimal expectedBalanceAfterAdding = BigDecimal.valueOf(4000);
        // when
        megaVisaGold.addBalance(addSumFromAtmDebitCard);
        BigDecimal balanceAfterAdd = megaVisaGold.getBalance();
        // then
        assertEquals(0, expectedBalanceAfterAdding.compareTo(balanceAfterAdd));
    }

    @Test
    void withdrawCreditCard_NegativeSumInput_Exception() {
        // given
        BigDecimal withdrawSumForCreditCard = BigDecimal.valueOf(-1000);
        String expectedMessage = "It was a negative input value!!!";
        // when
        Exception exception = assertThrows(NegativeInputException.class, () -> {
            superVisaGold.withdrawBalance(withdrawSumForCreditCard);
        });
        String actualMessage = exception.getMessage();
        // then
        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void withdrawDebitCard_NegativeSumInput_Exception() {
        // given
        BigDecimal withdrawSumForDebitCard = BigDecimal.valueOf(-2000);
        String expectedMessage = "It was a negative input value!!!";
        // when
        Exception exception = assertThrows(NegativeInputException.class, () -> {
            megaVisaGold.withdrawBalance(withdrawSumForDebitCard);
        });
        String actualMessage = exception.getMessage();
        // then
        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void addCreditCard_NegativeSumInput_Exception() {
        // given
        BigDecimal addSumForCreditCard = BigDecimal.valueOf(-1000);
        String expectedMessage = "It was a negative input value!!!";
        // when
        Exception exception = assertThrows(NegativeInputException.class, () -> {
            superVisaGold.withdrawBalance(addSumForCreditCard);
        });
        String actualMessage = exception.getMessage();
        // then
        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void addDebitCard_NegativeSumInput_Exception() {
        // given
        BigDecimal addSumForDebitCard = BigDecimal.valueOf(-1000);
        String expectedMessage = "It was a negative input value!!!";
        // when
        Exception exception = assertThrows(NegativeInputException.class, () -> {
            megaVisaGold.withdrawBalance(addSumForDebitCard);
        });
        String actualMessage = exception.getMessage();
        // then
        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void withdraw_NegativeBalanceAfterWithdrawing_Exception() {
        // given
        BigDecimal withdrawSumForDebitCard = BigDecimal.valueOf(3000);
        String expectedMessage = "The negative balance is not allowed!!! The operation is forbidden!!!";
        // when
        Exception exception = assertThrows(NegativeBalanceAfterWithdrawingException.class, () -> {
            megaVisaGold.withdrawBalance(withdrawSumForDebitCard);
        });
        String actualMessage = exception.getMessage();
        // then
        assertEquals(actualMessage, expectedMessage);
    }
}
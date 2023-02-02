package com.apaliakou.homework04.homeworkcard;

import com.apaliakou.homework04.homeworkcard.card.impl.CreditCard;
import com.apaliakou.homework04.homeworkcard.card.impl.DebitCard;
import com.apaliakou.homework04.homeworkcard.card.Card;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Double> currencyConversionList = new HashMap<>();

        currencyConversionList.put("USD", 1.00);
        currencyConversionList.put("EURO", 0.92);
        currencyConversionList.put("BYN", 2.67);
        currencyConversionList.put("RUB", 75.00);

        Card platinum = new CreditCard("Andrei", new BigDecimal("1000"));

        BigDecimal addSum = new BigDecimal("300");
        BigDecimal withdrawSum = new BigDecimal("1300");

        System.out.println("The platinum holder name: " + platinum.getHolderName() + ". The platinum balance in " +
                "the current currency: " + platinum.currencyConverter(currencyConversionList.get("RUB")) + ".");

        platinum.addBalance(addSum);
        System.out.println("The platinum balance after the adding: " + platinum.getBalance() + ".");

        platinum.withdrawBalance(withdrawSum);
        System.out.println("The platinum balance after the withdrawing: " + platinum.getBalance() + ".");

        BigDecimal resultAfterSeveralMathOperations = platinum.addBalance(addSum).withdrawBalance(withdrawSum).
                addBalance(addSum).getBalance();
        System.out.println("The result after several math operations: " + resultAfterSeveralMathOperations + ".");

        System.out.println();

        Card creditCard = new CreditCard("Masha", new BigDecimal("300"));
        Card debitCard = new DebitCard("Misha", new BigDecimal("300"));

        Atm creditAtm = new Atm(creditCard);
        Atm debitAtm = new Atm(debitCard);

        creditAtm.withdraw(new BigDecimal("400"));
        System.out.println("The credit card balance on the Atm after the withdrawing: " + creditAtm.getBalance() + ".");

        System.out.println();

        debitAtm.withdraw(new BigDecimal("400"));
        System.out.println("The debit card balance on the Atm after the withdrawing: " + debitAtm.getBalance() + ".");

    }
}

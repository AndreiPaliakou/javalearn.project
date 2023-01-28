package main.java.com.apaliakou.homework04.card;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Atp extends Card {

    public Atp(String holderName, BigDecimal balance) {
        super(holderName, balance);
    }

    public static void main(String[] args) {

        Map<String, Double> currencyConversionList = new HashMap<>();

        currencyConversionList.put("USD", 1.00);
        currencyConversionList.put("EURO", 0.92);
        currencyConversionList.put("BYN", 2.67);
        currencyConversionList.put("RUB", 75.00);

        Card platinum = new Card("Andrei", new BigDecimal("1000"));

        BigDecimal addSum = new BigDecimal("400");
        BigDecimal withdrawSum = new BigDecimal("1400");

        System.out.println("The platinum holder name: " + platinum.getHolderName() + ". The platinum balance in " +
                "the current currency: " + platinum.currencyConverter(currencyConversionList.get("USD")) + ".");

        BigDecimal resultAfterSeveralMathOperations = platinum.addBalance(addSum).withdrawBalance(withdrawSum).
                getBalance();
        System.out.println("The balance after the several operations: " + resultAfterSeveralMathOperations + ".");
        System.out.println();

        // The code fields for the inner classes

        Card.DebitCard platinumDebit = platinum.new DebitCard(platinum.getBalance());
        Card.CreditCard platinumCredit = platinum.new CreditCard(platinum.getBalance());

        System.out.println("The debit card balance before the next drawing: " + platinum.getBalance() + ".");
        platinumDebit.withdrawingOperationWithStop(withdrawSum);
        System.out.println("The debit card balance after the just happened drawing or after the withdrawing blocking: "
                + platinum.getBalance() + ".");
        System.out.println();

        System.out.println("The credit card balance before the next drawing: " + platinum.getBalance() + ".");
        platinumCredit.withdrawingOperationWithoutStop(withdrawSum);
        System.out.println("The credit card balance after the just happened drawing (with the debt formation): " +
                platinum.getBalance() + ".");
        System.out.println();
    }
}

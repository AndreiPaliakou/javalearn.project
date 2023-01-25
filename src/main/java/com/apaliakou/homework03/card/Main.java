package main.java.com.apaliakou.homework03.card;
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

        Card platinum = new Card("Andrei", new BigDecimal("3500"));

        BigDecimal addSum = new BigDecimal("500");
        BigDecimal withdrawSum = new BigDecimal("2000");

        System.out.println("The platinum holder name: " + platinum.getHolderName() + ". The platinum balance in " +
                "the current currency: " + platinum.currencyConverter(currencyConversionList.get("RUB")) + ".");

        platinum.addBalance(addSum);
        System.out.println("The platinum balance after the adding: " + platinum.getBalance() + ".");

        platinum.withdrawBalance(withdrawSum);
        System.out.println("The platinum balance after the withdrawing: " + platinum.getBalance() + ".");

        BigDecimal resultAfterSeveralMathOperations = platinum.addBalance(addSum).withdrawBalance(withdrawSum).
                addBalance(addSum).getBalance();
        System.out.println("The result after several math operations: " + resultAfterSeveralMathOperations + ".");

        Card visaGold = new Card("Vanya");
        System.out.println("The visa gold initial holder name and the balance: " + visaGold.getHolderName() + ", "
        + visaGold.getBalance() + ".");
    }
}

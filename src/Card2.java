import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class Card2 {
    private String holderName;
    private BigDecimal balance;

    public Card2(String holderName, BigDecimal currentAccountBalance) {
        this.holderName = holderName;
        this.balance = currentAccountBalance;
    }

    public Card2(String holderName) {
        this.holderName = holderName;
        this.balance = new BigDecimal("0");
    }

    public String getHolderName() {
        return holderName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setCurrentAccountBalance(BigDecimal currentAccountBalance) {
        this.balance = currentAccountBalance;
    }

    public Card2 addBalance(BigDecimal addSum) {
        if (checkIfPositive(addSum)) {
            this.balance = this.balance.add(addSum);
        } else {
            System.out.println("Enter the correct number");
        }
        return this;
    }

    public Card2 withdrawBalance(BigDecimal withdrawSum) {
        if (checkIfPositive(withdrawSum)) {
            this.balance = this.balance.subtract(withdrawSum);
        } else {
            System.out.println("Enter the correct number");
        }
        return this;
    }

    public BigDecimal convertBalance (Double currencyCoefficient) {
        BigDecimal coefficient = new BigDecimal(currencyCoefficient);
        boolean coefficientFeature = coefficient.compareTo(new BigDecimal("1")) < 1;
        boolean coefficientFeature2 = coefficient.compareTo(new BigDecimal("0")) <= 0;
        if (coefficientFeature) {
            return balance.divide(coefficient, 2, RoundingMode.HALF_UP);
        } else if (coefficientFeature2) {
            System.out.println("Enter the correct number");
            return balance;
        } else {
            return balance.multiply(coefficient);
        }
    }

    private boolean checkIfPositive (BigDecimal bigDecimalNumberToCheck) {
        return bigDecimalNumberToCheck.compareTo(new BigDecimal("0")) > 0;
    }
}

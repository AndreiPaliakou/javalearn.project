import java.math.BigDecimal;

public class initialInformation {
    private String cardHolderName;
    private BigDecimal accountBalanceInUsd;
    private BigDecimal accountBalanceInEuro;
    private BigDecimal accountBalanceInByn;
    private BigDecimal accountBalanceInRub;

    initialInformation(String cardHolderName, BigDecimal accountBalanceInUsd, BigDecimal accountBalanceInEuro, BigDecimal
            accountBalanceInByn, BigDecimal accountBalanceInRub) {
        this.cardHolderName = cardHolderName;
        this.accountBalanceInUsd = accountBalanceInUsd;
        this.accountBalanceInEuro = accountBalanceInEuro;
        this.accountBalanceInByn = accountBalanceInByn;
        this.accountBalanceInRub = accountBalanceInRub;
    }

    initialInformation(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }
}




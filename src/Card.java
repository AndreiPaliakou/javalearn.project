import java.math.BigDecimal;
import java.math.RoundingMode;

public class Card {
    public static void main(String[] args) {

        BigDecimal theCurrentAccountBalanceInUsd = new BigDecimal("3000.00");
        // The BigDecimal object was created for the initial balance sum in USD

        BigDecimal sumOfAddOrSubtractingInUsd = new BigDecimal("3000.0");
        BigDecimal euroCoefficient = new BigDecimal("0.92379");
        BigDecimal bynCoefficient = new BigDecimal("2.64");
        BigDecimal rubCoefficient = new BigDecimal("68.87");
        BigDecimal sumOfAddOrSubtractingInEuro = sumOfAddOrSubtractingInUsd.divide(euroCoefficient, 2,
                RoundingMode.HALF_UP);
        BigDecimal sumOfAddingOrSubtractingInByn = sumOfAddOrSubtractingInUsd.multiply(bynCoefficient);
        BigDecimal sumOfAddingOrSubtractingInRub = sumOfAddOrSubtractingInUsd.multiply(rubCoefficient);
        // The rate coefficients were considered in the exchange rate currencies (as of 19.01.2023)

        BigDecimal theCurrentAccountBalanceInEuro = theCurrentAccountBalanceInUsd.divide(euroCoefficient,
                2, RoundingMode.HALF_UP);
        // The BigDecimal object was created for the initial balance sum in EURO
        BigDecimal theCurrentAccountBalanceInByn = theCurrentAccountBalanceInUsd.multiply(bynCoefficient);
        // The BigDecimal object was created for the initial balance sum in BYN
        BigDecimal theCurrentAccountBalanceInRub = theCurrentAccountBalanceInUsd.multiply(rubCoefficient);
        // The BigDecimal object was created for the initial balance sum in RUB

        BigDecimal theBalanceAfterTheAddingInUsa = theCurrentAccountBalanceInUsd.add(sumOfAddOrSubtractingInUsd);
        // A new BigDecimal object was created for the new balance sum in USD by add() method using
        BigDecimal theBalanceAfterTheAddingInEuro = theCurrentAccountBalanceInEuro.add(sumOfAddOrSubtractingInEuro);
        // A new BigDecimal object was created for the new balance sum in EURO by add() method using
        BigDecimal theBalanceAfterTheAddingInByn = theCurrentAccountBalanceInByn.add(sumOfAddingOrSubtractingInByn);
        // A new BigDecimal object was created for the new balance sum in BYN by add() method using
        BigDecimal theBalanceAfterTheAddingInRub = theCurrentAccountBalanceInRub.add(sumOfAddingOrSubtractingInRub);
        // A new BigDecimal object was created for the new balance sum in RUB by add() method using

        BigDecimal theBalanceAfterTheSubtractingInUsd = theCurrentAccountBalanceInUsd.subtract(sumOfAddOrSubtractingInUsd);
        // A new BigDecimal object was created for the new balance sum in USD by subtract() method using
        BigDecimal theBalanceAfterTheSubtractingInEuro = theCurrentAccountBalanceInEuro.subtract(sumOfAddOrSubtractingInEuro);
        // A new BigDecimal object was created for the new balance sum in EURO by subtract() method using
        BigDecimal theBalanceAfterTheSubtractingInByn = theCurrentAccountBalanceInByn.subtract(sumOfAddingOrSubtractingInByn);
        // A new BigDecimal object was created for the new balance sum in BYN by subtract() method using
        BigDecimal theBalanceAfterTheSubtractingInRub = theCurrentAccountBalanceInRub.subtract(sumOfAddingOrSubtractingInRub);
        // A new BigDecimal object was created for the new balance sum in RUB by subtract() method using

        initialInformation theHolderInformationForTheFirstConstructor = new initialInformation("Andrei",
                theCurrentAccountBalanceInUsd, theCurrentAccountBalanceInEuro, theCurrentAccountBalanceInByn,
                theCurrentAccountBalanceInRub);
        // The Card object was created (a Card) according to the first constructor variant

        System.out.print("The first card holder name: \t\t\t\t\t");
        System.out.println(theHolderInformationForTheFirstConstructor.getCardHolderName() + ".");
        // The get() method was used to display the first holder name information

        System.out.print("The account balance for the first holder: \t\t");
        System.out.println(theCurrentAccountBalanceInUsd + " $ / " + theCurrentAccountBalanceInEuro + " euro / " +
                theCurrentAccountBalanceInByn + " bel.rub / " + theCurrentAccountBalanceInRub + " ros.rub /");
            // The get() method was used to display the account balance information in USD, EURO, BYN and RUB

        initialInformation theHolderNameForTheSecondConstructor = new initialInformation("Misha");
    /* A new Card object was created according to the second constructor variant
     (the constructor overloading was happened) */
        System.out.print("The second card holder name: \t\t\t\t\t");
        System.out.println(theHolderNameForTheSecondConstructor.getCardHolderName() + ".");
        // The get() method was used to display the second holder name information

        System.out.print("A new account balance after the adding: \t\t");
        System.out.println(theBalanceAfterTheAddingInUsa + " $ / " + theBalanceAfterTheAddingInEuro + " euro / " +
                theBalanceAfterTheAddingInByn + " bel.rub / " +
                theBalanceAfterTheAddingInRub + " ros.rub /");
        // A new account balance information displaying in USD, EURO, BYN and RUB after the adding

        System.out.print("A new account balance after the subtracting:\t");
        System.out.println(theBalanceAfterTheSubtractingInUsd + " $ / " + theBalanceAfterTheSubtractingInEuro +
                " euro / " + theBalanceAfterTheSubtractingInByn + " bel.rub / " +
                theBalanceAfterTheSubtractingInRub + " ros.rub /");
        // A new account balance information displaying in USD, EURO, BYN and RUB after the subtracting
    }

}
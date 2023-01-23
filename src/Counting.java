import java.math.BigDecimal;
import java.util.HashMap;

public class Counting {
    public static void main(String[] args) {
        HashMap<String, Double> table = new HashMap<String, Double>();
        table.put("USD", 1.0);
        table.put("EURO", 0.92);
        table.put("BYN", 2.67);
        table.put("RUB", 75.0);
        Card2 object = new Card2("Andrei", new BigDecimal(3000));
        BigDecimal addSum = new BigDecimal("1000.00");
        BigDecimal withdrawSum = new BigDecimal("3500.00");
        System.out.println("The balance sum (in the current currency): " + object.convertBalance(table.get("EURO")));
        object.addBalance(addSum);
        System.out.println("The balance sum (after the adding): " + object.getBalance());
        object.withdrawBalance(withdrawSum);
        System.out.println("The balance sum (after the subtracting): " + object.getBalance());

        BigDecimal result = object.addBalance(addSum).withdrawBalance(withdrawSum).addBalance(addSum).getBalance();
        System.out.println(result);

        Card2 newCard = new Card2("Misha");

        System.out.println(newCard.getBalance());

    }

}

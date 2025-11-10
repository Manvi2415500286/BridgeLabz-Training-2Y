import java.util.*;

public class BankSystem {
    public static void main(String[] args) {
        Map<String, Double> bank = new HashMap<>();

        bank.put("AC101", 10000.0);
        bank.put("AC102", 45000.0);
        bank.put("AC103", 52000.0);

        // deposit
        bank.put("AC101", bank.get("AC101") + 3000);

        // withdrawal with check
        double wd = 20000;
        if (bank.get("AC102") >= wd)
            bank.put("AC102", bank.get("AC102") - wd);
        else
            System.out.println("Insufficient funds");

        // sort by descending balance
        bank.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(System.out::println);

        // top 3 customers
        bank.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .forEach(e -> System.out.println("Top: " + e.getKey() + " = " + e.getValue()));
    }
}

import java.util.*;

public class SalaryDirectory {
    public static void main(String[] args) {
        Map<String, Double> emp = new HashMap<>();

        emp.put("Alice", 50000.0);
        emp.put("Bob", 60000.0);
        emp.put("Carol", 55000.0);

        // Raise
        emp.put("Bob", emp.get("Bob") * 1.10);

        // Average
        double avg = emp.values().stream().mapToDouble(d -> d).average().orElse(0);
        System.out.println("Average salary = " + avg);

        // Highest paid
        double max = Collections.max(emp.values());
        for (var e : emp.entrySet()) {
            if (e.getValue() == max) System.out.println("Top: " + e.getKey());
        }
    }
}

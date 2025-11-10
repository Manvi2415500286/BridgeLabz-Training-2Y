import java.util.*;

public class InventoryManagement {
    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>();

        stock.put("Laptop", 10);
        stock.put("Mouse", 20);

        // purchase
        stock.put("Laptop", stock.get("Laptop") - 9);

        if (stock.get("Laptop") <= 0) stock.put("Laptop", 0);

        // new shipment
        stock.put("Mouse", stock.get("Mouse") + 30);

        // query
        String item = "Laptop";
        System.out.println(item + " remaining: " + stock.getOrDefault(item, -1));

        // out of stock
        for (var e : stock.entrySet()) {
            if (e.getValue() == 0) System.out.println("Out of stock: " + e.getKey());
        }
    }
}

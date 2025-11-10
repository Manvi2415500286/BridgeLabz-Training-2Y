import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        Map<String, Double> cart = new LinkedHashMap<>();

        cart.put("Laptop", 40000.0);
        cart.put("Mouse", 500.0);
        cart.put("Bag", 1200.0);

        // show in insertion order
        System.out.println(cart);

        // total
        double total = cart.values().stream().mapToDouble(d -> d).sum();
        if (total > 5000) total *= 0.90;

        System.out.println("Total after discount = " + total);

        // remove item
        cart.remove("Mouse");

        System.out.println("Updated cart: " + cart);
    }
}

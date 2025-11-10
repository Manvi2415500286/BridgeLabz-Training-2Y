import java.util.*;

abstract class Product {
    abstract double getPrice();
}

class Mobile extends Product {
    double price;
    Mobile(double p) { price = p; }
    double getPrice() { return price; }
}

class Laptop extends Product {
    double price;
    Laptop(double p) { price = p; }
    double getPrice() { return price; }
}

public class PriceCalculator {
    public static double calculateTotal(List<? extends Product> items) {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    public static void main(String[] args) {
        List<Mobile> mobiles = List.of(new Mobile(20000), new Mobile(15000));
        List<Laptop> laptops = List.of(new Laptop(50000), new Laptop(60000));

        System.out.println(calculateTotal(mobiles));
        System.out.println(calculateTotal(laptops));
    }
}

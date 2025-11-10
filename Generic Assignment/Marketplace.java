interface Category {}

enum BookCategory implements Category { FICTION, TECH }
enum ClothingCategory implements Category { MEN, WOMEN }

class Product<T extends Category> {
    String name;
    T category;
    double price;

    Product(String n, T c, double p){ name=n; category=c; price=p; }

    public String toString(){ return name+" ("+category+") = ₹"+price; }
}

public class Marketplace {
    public static <T extends Product<?>> void applyDiscount(T product, double percent) {
        product.price = product.price * (100 - percent) / 100.0;
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Book", BookCategory.TECH, 600);
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", ClothingCategory.MEN, 800);

        applyDiscount(book, 10);
        applyDiscount(shirt, 20);

        System.out.println(book);
        System.out.println(shirt);
    }
}

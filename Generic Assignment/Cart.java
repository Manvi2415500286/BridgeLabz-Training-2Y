import java.util.*;

class Cart<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) { items.add(item); }
    public void removeItem(T item) { items.remove(item); }
    public void displayItems() { System.out.println(items); }

    public static void main(String[] args) {
        class Electronics { public String toString(){ return "Phone"; } }
        class Clothing { public String toString(){ return "Shirt"; } }

        Cart<Electronics> eCart = new Cart<>();
        eCart.addItem(new Electronics());
        eCart.displayItems();

        Cart<Clothing> cCart = new Cart<>();
        cCart.addItem(new Clothing());
        cCart.displayItems();
    }
}

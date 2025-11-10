import java.util.*;

abstract class WarehouseItem {
    String name;
    WarehouseItem(String n){ name = n; }
    public String toString(){ return name; }
}

class Electronics extends WarehouseItem { Electronics(String n){ super(n); } }
class Groceries extends WarehouseItem { Groceries(String n){ super(n); } }
class Furniture extends WarehouseItem { Furniture(String n){ super(n); } }

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void add(T item){ items.add(item); }
    public List<T> getItems(){ return items; }

    public static void display(List<? extends WarehouseItem> list) {
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Storage<Electronics> eStore = new Storage<>();
        eStore.add(new Electronics("Laptop"));

        Storage<Groceries> gStore = new Storage<>();
        gStore.add(new Groceries("Rice"));

        display(eStore.getItems());
        display(gStore.getItems());
    }
}

import java.util.*;

class Fruit {
    String name;
    Fruit(String name) { this.name = name; }
    public String toString() { return name; }
}

class Apple extends Fruit {
    Apple() { super("Apple"); }
}

class Mango extends Fruit {
    Mango() { super("Mango"); }
}

class FruitBox<T extends Fruit> {
    private List<T> list = new ArrayList<>();

    public void add(T fruit) {
        list.add(fruit);
    }

    public void display() {
        System.out.println(list);
    }

    public static void main(String[] args) {
        FruitBox<Apple> box = new FruitBox<>();
        box.add(new Apple());
        box.add(new Apple());

        FruitBox<Mango> box2 = new FruitBox<>();
        box2.add(new Mango());

        box.display();
        box2.display();

        // ❌ FruitBox<Car> invalid – won’t compile.
    }
}

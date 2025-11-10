import java.util.*;

class Animal { public String toString(){ return getClass().getSimpleName(); } }

class Dog extends Animal {}
class Cat extends Animal {}

public class AnimalPrinter {
    public static void printAnimals(List<? extends Animal> animals) {
        animals.forEach(System.out::println);
    }

    public static void main(String[] args) {
        printAnimals(List.of(new Dog(), new Dog()));
        printAnimals(List.of(new Cat(), new Cat()));
    }
}

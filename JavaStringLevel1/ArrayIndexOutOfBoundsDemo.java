import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {
    public static void generateError(String[] arr) {
        System.out.println(arr[arr.length]); // out of range
    }

    public static void handleError(String[] arr) {
        try {
            System.out.println(arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Alice", "Bob", "Charlie"};

        // generateError(names); // Uncomment to crash
        handleError(names);
    }
}
s
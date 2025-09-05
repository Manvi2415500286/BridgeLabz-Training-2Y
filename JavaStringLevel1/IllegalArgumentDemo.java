import java.util.Scanner;

public class IllegalArgumentDemo {
    public static void generateError(String str) {
        System.out.println(str.substring(5, 2)); // start > end
    }

    public static void handleError(String str) {
        try {
            System.out.println(str.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        // generateError(text); // Uncomment to crash
        handleError(text);
    }
}

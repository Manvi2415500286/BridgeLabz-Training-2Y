import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    public static void generateError(String str) {
        System.out.println(str.charAt(str.length())); // out of range
    }

    public static void handleError(String str) {
        try {
            System.out.println(str.charAt(str.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e);
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

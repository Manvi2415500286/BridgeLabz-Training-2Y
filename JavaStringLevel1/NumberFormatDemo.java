
import java.util.Scanner;

public class NumberFormatDemo {
    public static void generateError(String str) {
        int num = Integer.parseInt(str); // if not numeric, throws exception
        System.out.println("Number: " + num);
    }

    public static void handleError(String str) {
        try {
            int num = Integer.parseInt(str);
            System.out.println("Number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e);
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

import java.util.Scanner;

public class StringLengthDemo {
    public static int myLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        int len1 = myLength(text);
        int len2 = text.length();

        System.out.println("Length (user method): " + len1);
        System.out.println("Length (built-in): " + len2);
    }
}

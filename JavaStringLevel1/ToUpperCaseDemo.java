import java.util.Scanner;

public class ToUpperCaseDemo {
    public static String myToUpperCase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                result += (char)(c - 32);
            } else {
                result += c;
            }
        }
        return result;
    }

    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String upper1 = myToUpperCase(text);
        String upper2 = text.toUpperCase();

        System.out.println("User method: " + upper1);
        System.out.println("Built-in: " + upper2);
        System.out.println("Are they equal? " + compareUsingCharAt(upper1, upper2));
    }
}

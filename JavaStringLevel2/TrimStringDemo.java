import java.util.Scanner;

public class TrimStringDemo {
    // Method to find start & end indexes after trimming spaces
    public static int[] findTrimIndexes(String str) {
        int start = 0, end = str.length() - 1;

        // Trim leading spaces
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // Method to create substring using charAt()
    public static String substringUsingCharAt(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text with spaces: ");
        String text = sc.nextLine();

        int[] indexes = findTrimIndexes(text);
        String trimmedUser = substringUsingCharAt(text, indexes[0], indexes[1]);
        String trimmedBuiltIn = text.trim();

        System.out.println("User Method Trimmed: '" + trimmedUser + "'");
        System.out.println("Built-in Trimmed:   '" + trimmedBuiltIn + "'");
        System.out.println("Are they equal? " + compareUsingCharAt(trimmedUser, trimmedBuiltIn));
    }
}

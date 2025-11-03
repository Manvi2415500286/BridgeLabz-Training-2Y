import java.util.*;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        if (isPalindrome(str))
            System.out.println(str + " is a Palindrome.");
        else
            System.out.println(str + " is NOT a Palindrome.");
    }

    static boolean isPalindrome(String s) {
        s = s.replaceAll("\\s+", "").toLowerCase();
        String rev = new StringBuilder(s).reverse().toString();
        return s.equals(rev);
    }
}

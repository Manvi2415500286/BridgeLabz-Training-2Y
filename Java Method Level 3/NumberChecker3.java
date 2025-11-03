import java.util.*;

public class NumberChecker3 {
    public static void main(String[] args) {
        int number = 1221;
        int[] digits = extractDigits(number);
        int[] rev = reverseArray(digits);
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Reversed: " + Arrays.toString(rev));
        System.out.println("Arrays equal? " + Arrays.equals(digits, rev));
        System.out.println("Is Palindrome? " + isPalindrome(digits));
        System.out.println("Is Duck Number? " + isDuck(digits));
    }

    public static int[] extractDigits(int n) {
        String s = String.valueOf(n);
        int[] d = new int[s.length()];
        for (int i = 0; i < s.length(); i++) d[i] = s.charAt(i) - '0';
        return d;
    }

    public static int[] reverseArray(int[] arr) {
        int[] r = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            r[i] = arr[arr.length - 1 - i];
        return r;
    }

    public static boolean isPalindrome(int[] digits) {
        return Arrays.equals(digits, reverseArray(digits));
    }

    public static boolean isDuck(int[] digits) {
        for (int d : digits) if (d == 0) return true;
        return false;
    }
}

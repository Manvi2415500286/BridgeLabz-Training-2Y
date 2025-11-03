import java.util.*;

public class NumberChecker1 {
    public static void main(String[] args) {
        int number = 153;
        int count = countDigits(number);
        int[] digits = extractDigits(number);

        System.out.println("Count of digits: " + count);
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Is Duck Number? " + isDuckNumber(digits));
        System.out.println("Is Armstrong? " + isArmstrong(digits));
        int[] largestTwo = findLargestTwo(digits);
        int[] smallestTwo = findSmallestTwo(digits);
        System.out.println("Largest, 2nd Largest: " + Arrays.toString(largestTwo));
        System.out.println("Smallest, 2nd Smallest: " + Arrays.toString(smallestTwo));
    }

    public static int countDigits(int n) { return String.valueOf(n).length(); }

    public static int[] extractDigits(int n) {
        String s = String.valueOf(n);
        int[] d = new int[s.length()];
        for (int i = 0; i < s.length(); i++) d[i] = s.charAt(i) - '0';
        return d;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) if (d == 0) return true;
        return false;
    }

    public static boolean isArmstrong(int[] digits) {
        int pow = digits.length, sum = 0;
        for (int d : digits) sum += Math.pow(d, pow);
        int num = 0;
        for (int d : digits) num = num * 10 + d;
        return num == sum;
    }

    public static int[] findLargestTwo(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int v : arr) {
            if (v > first) { second = first; first = v; }
            else if (v > second && v != first) second = v;
        }
        return new int[]{first, second};
    }

    public static int[] findSmallestTwo(int[] arr) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int v : arr) {
            if (v < first) { second = first; first = v; }
            else if (v < second && v != first) second = v;
        }
        return new int[]{first, second};
    }
}

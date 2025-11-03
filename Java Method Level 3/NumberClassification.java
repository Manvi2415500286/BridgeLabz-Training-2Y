import java.util.Scanner;

public class NumberClassification {

    // Sum of proper divisors (excluding the number itself)
    public static int sumProperDivisors(int n) {
        if (n <= 1) return 0;
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                int j = n / i;
                sum += i;
                if (j != i) sum += j;
            }
        }
        return sum;
    }

    public static boolean isPerfect(int n) {
        return n > 1 && sumProperDivisors(n) == n;
    }

    public static boolean isAbundant(int n) {
        return sumProperDivisors(n) > n;
    }

    public static boolean isDeficient(int n) {
        return sumProperDivisors(n) < n;
    }

    // factorial
    public static long factorial(int x) {
        long f = 1;
        for (int i = 2; i <= x; i++) f *= i;
        return f;
    }

    // strong number: sum of factorials of digits equals number
    public static boolean isStrong(int n) {
        int t = n;
        long sum = 0;
        while (t > 0) {
            int d = t % 10;
            sum += factorial(d);
            t /= 10;
        }
        return sum == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        System.out.println("Number: " + n);
        System.out.println("Perfect? " + isPerfect(n));
        System.out.println("Abundant? " + isAbundant(n));
        System.out.println("Deficient? " + isDeficient(n));
        System.out.println("Strong? " + isStrong(n));
    }
}

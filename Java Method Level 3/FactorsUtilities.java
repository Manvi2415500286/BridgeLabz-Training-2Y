import java.util.Arrays;
import java.util.Scanner;

public class FactorsUtilities {

    public static int[] findFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) count++;
        int[] fac = new int[count];
        int idx = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) fac[idx++] = i;
        return fac;
    }

    public static int greatestProperFactor(int n, int[] factors) {
        // greatest factor less than n
        for (int i = factors.length - 1; i >= 0; i--) {
            if (factors[i] < n) return factors[i];
        }
        return 1; // fallback
    }

    public static long sumOfFactors(int[] factors) {
        long sum = 0;
        for (int f : factors) sum += f;
        return sum;
    }

    public static long productOfFactors(int[] factors) {
        long prod = 1;
        for (int f : factors) prod *= f;
        return prod;
    }

    public static double productOfCubes(int[] factors) {
        double prod = 1.0;
        for (int f : factors) prod *= Math.pow(f, 3);
        return prod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Enter positive integer.");
            return;
        }

        int[] fac = findFactors(n);
        System.out.println("Factors: " + Arrays.toString(fac));
        System.out.println("Greatest proper factor: " + greatestProperFactor(n, fac));
        System.out.println("Sum of factors: " + sumOfFactors(fac));
        System.out.println("Product of factors: " + productOfFactors(fac));
        System.out.println("Product of cubes of factors: " + productOfCubes(fac));
    }
}

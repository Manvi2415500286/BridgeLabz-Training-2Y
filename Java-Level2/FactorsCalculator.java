import java.util.Scanner;

public class FactorsCalculator {
    public static int[] findFactors(int num) {
        int count = 0;
        // count factors
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) count++;
        }
        // store factors
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) factors[index++] = i;
        }
        return factors;
    }

    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) sum += f;
        return sum;
    }

    public static int productOfFactors(int[] factors) {
        int product = 1;
        for (int f : factors) product *= f;
        return product;
    }

    public static int sumOfSquares(int[] factors) {
        int sum = 0;
        for (int f : factors) sum += Math.pow(f, 2);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int[] factors = findFactors(num);
        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");

        System.out.println("\nSum of factors = " + sumOfFactors(factors));
        System.out.println("Product of factors = " + productOfFactors(factors));
        System.out.println("Sum of squares of factors = " + sumOfSquares(factors));
    }
}

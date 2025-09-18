import java.util.Scanner;

public class SumNaturalNumbers2 {

    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        int sum = calculateSum(n);

        System.out.printf("Sum of first %d natural numbers is %d%n", n, sum);

        scanner.close();
    }
}

import java.util.Scanner;

public class SumNaturalNumbers {

    public static int recursiveSum(int n) {
        if (n == 1)
            return 1;
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Not a natural number!");
            return;
        }

        int recSum = recursiveSum(n);
        int formSum = formulaSum(n);

        System.out.println("Sum using recursion: " + recSum);
        System.out.println("Sum using formula: " + formSum);
        System.out.println("Both are equal: " + (recSum == formSum));
    }
}

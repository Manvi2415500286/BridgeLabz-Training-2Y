import java.util.Scanner;

public class FibonacciGenerator {

    public static void printFibonacci(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci sequence: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();
        printFibonacci(n);
    }
}

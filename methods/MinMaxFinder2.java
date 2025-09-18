import java.util.Scanner;

public class MinMaxFinder2 {

    public static int findSmallest(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static int findLargest(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter three numbers (space-separated): ");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        int smallest = findSmallest(n1, n2, n3);
        int largest = findLargest(n1, n2, n3);

        System.out.printf("Smallest number is: %d%n", smallest);
        System.out.printf("Largest number is: %d%n", largest);

        scanner.close();
    }
}

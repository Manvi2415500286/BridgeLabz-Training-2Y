import java.util.Scanner;

public class MinMaxFinder {

    public static int[] findSmallestAndLargest(int n1, int n2, int n3) {
        int min = Math.min(n1, Math.min(n2, n3));
        int max = Math.max(n1, Math.max(n2, n3));
        return new int[] {min, max};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers separated by spaces: ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        int[] result = findSmallestAndLargest(n1, n2, n3);
        System.out.println("Smallest number: " + result[0]);
        System.out.println("Largest number: " + result[1]);
    }
}

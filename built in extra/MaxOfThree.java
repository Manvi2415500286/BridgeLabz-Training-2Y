import java.util.Scanner;

public class MaxOfThree {

    public static int findMax(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    public static int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = takeInput();
        int max = findMax(numbers[0], numbers[1], numbers[2]);
        System.out.println("Maximum number is: " + max);
    }
}

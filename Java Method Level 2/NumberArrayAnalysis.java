import java.util.Scanner;

public class NumberArrayAnalysis {

    public static boolean isPositive(int num) {
        return num >= 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int compare(int n1, int n2) {
        if (n1 > n2) return 1;
        else if (n1 == n2) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            nums[i] = sc.nextInt();

            if (isPositive(nums[i])) {
                System.out.print(nums[i] + " is Positive and ");
                if (isEven(nums[i])) System.out.println("Even.");
                else System.out.println("Odd.");
            } else {
                System.out.println(nums[i] + " is Negative.");
            }
        }

        int result = compare(nums[0], nums[4]);
        if (result == 0)
            System.out.println("First and last numbers are equal.");
        else if (result > 0)
            System.out.println("First number is greater than last.");
        else
            System.out.println("First number is smaller than last.");
    }
}

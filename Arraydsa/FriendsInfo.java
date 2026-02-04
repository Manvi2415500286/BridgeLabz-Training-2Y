import java.util.Scanner;

class FriendsInfo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] age = new int[3];
        double[] height = new double[3];

        // Input age and height
        for (int index = 0; index < names.length; index++) {

            System.out.print("Enter age of " + names[index] + ": ");
            age[index] = scanner.nextInt();

            System.out.print("Enter height of " + names[index] + ": ");
            height[index] = scanner.nextDouble();

            if (age[index] <= 0 || height[index] <= 0) {
                System.out.println("Invalid input. Try again.");
                index--;
            }
        }

        int youngestIndex = 0;
        int tallestIndex = 0;

        // Find youngest and tallest
        for (int index = 1; index < names.length; index++) {

            if (age[index] < age[youngestIndex]) {
                youngestIndex = index;
            }

            if (height[index] > height[tallestIndex]) {
                tallestIndex = index;
            }
        }

        System.out.println("Youngest: " + names[youngestIndex]);
        System.out.println("Tallest: " + names[tallestIndex]);

        scanner.close();
    }
}

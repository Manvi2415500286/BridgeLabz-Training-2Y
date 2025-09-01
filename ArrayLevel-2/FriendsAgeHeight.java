import java.util.Scanner;

public class FriendsAgeHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] age = new int[3];
        double[] height = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter age of " + names[i] + ": ");
            age[i] = sc.nextInt();
            System.out.println("Enter height of " + names[i] + ": ");
            height[i] = sc.nextDouble();
        }

        int minAgeIndex = 0, maxHeightIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (age[i] < age[minAgeIndex]) minAgeIndex = i;
            if (height[i] > height[maxHeightIndex]) maxHeightIndex = i;
        }

        System.out.println("Youngest: " + names[minAgeIndex] + " (Age: " + age[minAgeIndex] + ")");
        System.out.println("Tallest: " + names[maxHeightIndex] + " (Height: " + height[maxHeightIndex] + ")");

        sc.close();
    }
}


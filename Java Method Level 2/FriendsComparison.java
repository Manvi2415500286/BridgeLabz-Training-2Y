import java.util.Scanner;

public class FriendsComparison {

    public static int findYoungest(int[] ages) {
        int min = ages[0];
        int index = 0;
        for (int i = 1; i < ages.length; i++)
            if (ages[i] < min) {
                min = ages[i];
                index = i;
            }
        return index;
    }

    public static int findTallest(double[] heights) {
        double max = heights[0];
        int index = 0;
        for (int i = 1; i < heights.length; i++)
            if (heights[i] > max) {
                max = heights[i];
                index = i;
            }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height (in cm) of " + names[i] + ": ");
            heights[i] = sc.nextDouble();
        }

        int youngest = findYoungest(ages);
        int tallest = findTallest(heights);

        System.out.println("Youngest: " + names[youngest]);
        System.out.println("Tallest: " + names[tallest]);
    }
}

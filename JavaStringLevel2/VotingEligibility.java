import java.util.Random;

public class VotingEligibility {
    // Generate random ages
    public static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = 10 + rand.nextInt(90); // random 2-digit age
        }
        return ages;
    }

    // Check eligibility and return 2D array
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                result[i][1] = "false"; // invalid
            } else {
                result[i][1] = (ages[i] >= 18) ? "true" : "false";
            }
        }
        return result;
    }

    // Display table
    public static void display(String[][] data) {
        System.out.println("Age\tCan Vote?");
        for (String[] row : data) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        int[] ages = generateAges(10);
        String[][] table = checkVotingEligibility(ages);
        display(table);
    }
}

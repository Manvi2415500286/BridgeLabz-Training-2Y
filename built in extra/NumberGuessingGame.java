import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static int generateGuess(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    public static String getUserFeedback(int guess) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Is your number " + guess + "? (high/low/correct): ");
        return sc.nextLine().toLowerCase();
    }

    public static void main(String[] args) {
        int min = 1, max = 100;
        String feedback = "";
        System.out.println("Think of a number between 1 and 100.");
        while (!feedback.equals("correct")) {
            int guess = generateGuess(min, max);
            feedback = getUserFeedback(guess);
            if (feedback.equals("high")) max = guess - 1;
            else if (feedback.equals("low")) min = guess + 1;
        }
        System.out.println("Hurray! Computer guessed your number.");
    }
}

import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int low = 1, high = 100;
        String feedback = "";

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it!");

        while (!feedback.equalsIgnoreCase("correct")) {
            int guess = random.nextInt(high - low + 1) + low;
            System.out.println("Is your number " + guess + "? (Enter 'high', 'low', or 'correct')");
            feedback = sc.next();

            if (feedback.equalsIgnoreCase("high"))
                high = guess - 1;
            else if (feedback.equalsIgnoreCase("low"))
                low = guess + 1;
            else if (feedback.equalsIgnoreCase("correct"))
                System.out.println("Yay! I guessed your number correctly!");
            else
                System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
        }
    }
}

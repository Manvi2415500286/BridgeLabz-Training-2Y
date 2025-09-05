import java.util.Scanner;

public class RockPaperScissors {
    // Get computer choice
    public static String getComputerChoice() {
        int val = (int) (Math.random() * 3);
        if (val == 0) return "rock";
        else if (val == 1) return "paper";
        else return "scissors";
    }

    // Find winner
    public static String findWinner(String user, String comp) {
        if (user.equals(comp)) return "Draw";
        if ((user.equals("rock") && comp.equals("scissors")) ||
            (user.equals("paper") && comp.equals("rock")) ||
            (user.equals("scissors") && comp.equals("paper"))) {
            return "User";
        }
        return "Computer";
    }

    // Display stats
    public static void displayStats(int userWins, int compWins, int games) {
        double userPercent = (userWins * 100.0) / games;
        double compPercent = (compWins * 100.0) / games;
        System.out.println("\nGame Summary:");
        System.out.println("User Wins: " + userWins + " (" + String.format("%.2f", userPercent) + "%)");
        System.out.println("Computer Wins: " + compWins + " (" + String.format("%.2f", compPercent) + "%)");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many games do you want to play? ");
        int games = sc.nextInt();

        int userWins = 0, compWins = 0;

        for (int i = 1; i <= games; i++) {
            System.out.print("\nGame " + i + " - Enter rock, paper, or scissors: ");
            String user = sc.next().toLowerCase();
            String comp = getComputerChoice();
            String winner = findWinner(user, comp);

            System.out.println("Computer chose: " + comp);
            System.out.println("Winner: " + winner);

            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) compWins++;
        }

        displayStats(userWins, compWins, games);
    }
}

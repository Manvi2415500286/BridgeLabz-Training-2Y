import java.util.Random;

public class StudentScoreCard {
    // Generate random PCM marks
    public static int[][] generateScores(int students) {
        Random rand = new Random();
        int[][] scores = new int[students][3]; // Physics, Chemistry, Math
        for (int i = 0; i < students; i++) {
            scores[i][0] = 40 + rand.nextInt(61); // 40–100
            scores[i][1] = 40 + rand.nextInt(61);
            scores[i][2] = 40 + rand.nextInt(61);
        }
        return scores;
    }

    // Calculate totals, averages, percentages
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3]; // total, avg, percent
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;
            results[i][0] = total;
            results[i][1] = Math.round(avg * 100.0) / 100.0;
            results[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return results;
    }

    // Assign grades
    public static String[] assignGrades(double[][] results) {
        String[] grades = new String[results.length];
        for (int i = 0; i < results.length; i++) {
            double percent = results[i][2];
            if (percent >= 90) grades[i] = "A";
            else if (percent >= 75) grades[i] = "B";
            else if (percent >= 60) grades[i] = "C";
            else if (percent >= 40) grades[i] = "D";
            else grades[i] = "F";
        }
        return grades;
    }

    // Display scorecard
    public static void displayScoreCard(int[][] scores, double[][] results, String[] grades) {
        System.out.println("Phy\tChem\tMath\tTotal\tAvg\tPercent\tGrade");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i][0] + "\t" + scores[i][1] + "\t" + scores[i][2] + "\t" +
                               (int) results[i][0] + "\t" + results[i][1] + "\t" + results[i][2] + "\t" + grades[i]);
        }
    }

    public static void main(String[] args) {
        int students = 5; // can be changed
        int[][] scores = generateScores(students);
        double[][] results = calculateResults(scores);
        String[] grades = assignGrades(results);
        displayScoreCard(scores, results, grades);
    }
}

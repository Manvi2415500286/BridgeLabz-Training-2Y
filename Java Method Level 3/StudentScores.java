import java.util.Random;
import java.util.Scanner;

public class StudentScores {

    public static double[][] generateScores(int n) {
        double[][] scores = new double[n][3];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            scores[i][0] = 40 + r.nextInt(61); // physics
            scores[i][1] = 40 + r.nextInt(61); // chemistry
            scores[i][2] = 40 + r.nextInt(61); // maths
        }
        return scores;
    }

    public static double[][] calculateResults(double[][] marks) {
        double[][] result = new double[marks.length][3]; // total, avg, %
        for (int i = 0; i < marks.length; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            double percent = Math.round((avg) * 100.0) / 100.0;
            result[i][0] = total;
            result[i][1] = avg;
            result[i][2] = percent;
        }
        return result;
    }

    public static void displayScorecard(double[][] marks, double[][] results) {
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t%");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%d\t%.0f\t%.0f\t%.0f\t%.0f\t%.2f\t%.2f%n",
                    i+1, marks[i][0], marks[i][1], marks[i][2],
                    results[i][0], results[i][1], results[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[][] marks = generateScores(n);
        double[][] results = calculateResults(marks);
        displayScorecard(marks, results);
    }
}

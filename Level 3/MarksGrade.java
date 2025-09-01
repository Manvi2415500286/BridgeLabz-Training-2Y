
import java.util.Scanner;

public class MarksGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks in Physics: ");
        int physics = sc.nextInt();
        System.out.print("Enter marks in Chemistry: ");
        int chemistry = sc.nextInt();
        System.out.print("Enter marks in Maths: ");
        int maths = sc.nextInt();

        double avg = (physics + chemistry + maths) / 3.0;
        System.out.println("Average Marks: " + avg);

        if (avg >= 90) {
            System.out.println("Grade: A+ | Excellent");
        } else if (avg >= 75) {
            System.out.println("Grade: A | Very Good");
        } else if (avg >= 60) {
            System.out.println("Grade: B | Good");
        } else if (avg >= 50) {
            System.out.println("Grade: C | Pass");
        } else {
            System.out.println("Grade: F | Fail");
        }
    }
}

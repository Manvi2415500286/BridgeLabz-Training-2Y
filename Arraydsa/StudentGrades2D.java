import java.util.Scanner;

class StudentGrades2D {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = scanner.nextInt();

        int[][] marks = new int[students][3];
        double[] percentage = new double[students];
        char[] grade = new char[students];

        // Input marks
        for (int index = 0; index < students; index++) {

            System.out.print("Enter Physics, Chemistry, Maths marks: ");
            marks[index][0] = scanner.nextInt();
            marks[index][1] = scanner.nextInt();
            marks[index][2] = scanner.nextInt();

            if (marks[index][0] < 0 || marks[index][1] < 0 || marks[index][2] < 0) {
                System.out.println("Invalid input. Re-enter.");
                index--;
            }
        }

        // Calculate percentage and grade
        for (int index = 0; index < students; index++) {

            percentage[index] =
                (marks[index][0] + marks[index][1] + marks[index][2]) / 3.0;

            if (percentage[index] >= 90) {
                grade[index] = 'A';
            } else if (percentage[index] >= 75) {
                grade[index] = 'B';
            } else if (percentage[index] >= 60) {
                grade[index] = 'C';
            } else {
                grade[index] = 'D';
            }
        }

        // Display output
        for (int index = 0; index < students; index++) {
            System.out.println("Percentage: " + percentage[index] +
                               " Grade: " + grade[index]);
        }

        scanner.close();
    }
}

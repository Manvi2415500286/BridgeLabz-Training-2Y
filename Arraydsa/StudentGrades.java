import java.util.Scanner;

class StudentGrades {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = scanner.nextInt();

        int[] physics = new int[students];
        int[] chemistry = new int[students];
        int[] maths = new int[students];
        double[] percentage = new double[students];
        char[] grade = new char[students];

        // Input marks
        for (int index = 0; index < students; index++) {

            System.out.print("Enter Physics marks: ");
            physics[index] = scanner.nextInt();

            System.out.print("Enter Chemistry marks: ");
            chemistry[index] = scanner.nextInt();

            System.out.print("Enter Maths marks: ");
            maths[index] = scanner.nextInt();

            if (physics[index] < 0 || chemistry[index] < 0 || maths[index] < 0) {
                System.out.println("Invalid marks. Re-enter.");
                index--;
            }
        }

        // Calculate percentage and grade
        for (int index = 0; index < students; index++) {

            percentage[index] =
                (physics[index] + chemistry[index] + maths[index]) / 3.0;

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

        // Display result
        System.out.println("\nPercentage\tGrade");
        for (int index = 0; index < students; index++) {
            System.out.println(percentage[index] + "\t\t" + grade[index]);
        }

        scanner.close();
    }
}

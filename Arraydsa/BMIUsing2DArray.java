import java.util.Scanner;

class BMIUsing2DArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = scanner.nextInt();

        // personData[row][0] = weight, [1] = height, [2] = BMI
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // Input weight and height
        for (int index = 0; index < number; index++) {

            System.out.print("Enter weight of person " + (index + 1) + ": ");
            personData[index][0] = scanner.nextDouble();

            System.out.print("Enter height of person " + (index + 1) + ": ");
            personData[index][1] = scanner.nextDouble();

            if (personData[index][0] <= 0 || personData[index][1] <= 0) {
                System.out.println("Invalid input. Enter positive values.");
                index--;
            }
        }

        // Calculate BMI and status
        for (int index = 0; index < number; index++) {

            personData[index][2] =
                personData[index][0] /
                (personData[index][1] * personData[index][1]);

            if (personData[index][2] < 18.5) {
                weightStatus[index] = "Underweight";
            } else if (personData[index][2] < 25) {
                weightStatus[index] = "Normal";
            } else if (personData[index][2] < 30) {
                weightStatus[index] = "Overweight";
            } else {
                weightStatus[index] = "Obese";
            }
        }

        // Display output
        System.out.println("\nWeight\tHeight\tBMI\tStatus");
        for (int index = 0; index < number; index++) {
            System.out.println(personData[index][0] + "\t" +
                               personData[index][1] + "\t" +
                               personData[index][2] + "\t" +
                               weightStatus[index]);
        }

        scanner.close();
    }
}

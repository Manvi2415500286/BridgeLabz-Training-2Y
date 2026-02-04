import java.util.Scanner;

class BMICalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take number of persons
        System.out.print("Enter number of persons: ");
        int numberOfPersons = scanner.nextInt();

        // Declare arrays
        double[] weight = new double[numberOfPersons];
        double[] height = new double[numberOfPersons];
        double[] bmi = new double[numberOfPersons];
        String[] status = new String[numberOfPersons];

        // Input height and weight
        for (int index = 0; index < numberOfPersons; index++) {

            System.out.print("Enter weight (kg) of person " + (index + 1) + ": ");
            weight[index] = scanner.nextDouble();

            System.out.print("Enter height (m) of person " + (index + 1) + ": ");
            height[index] = scanner.nextDouble();

            // Validate input
            if (weight[index] <= 0 || height[index] <= 0) {
                System.out.println("Invalid input. Enter positive values.");
                index--;
            }
        }

        // Calculate BMI and status
        for (int index = 0; index < numberOfPersons; index++) {

            bmi[index] = weight[index] / (height[index] * height[index]);

            if (bmi[index] < 18.5) {
                status[index] = "Underweight";
            } else if (bmi[index] < 25) {
                status[index] = "Normal";
            } else if (bmi[index] < 30) {
                status[index] = "Overweight";
            } else {
                status[index] = "Obese";
            }
        }

        // Display results
        System.out.println("\nHeight\tWeight\tBMI\tStatus");
        for (int index = 0; index < numberOfPersons; index++) {
            System.out.println(height[index] + "\t" + weight[index] + "\t" +
                               bmi[index] + "\t" + status[index]);
        }

        scanner.close();
    }
}

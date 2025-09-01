import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[][] personData = new double[n][3]; // [weight, height, BMI]
        String[] weightStatus = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i+1) + ": ");
            personData[i][0] = sc.nextDouble();
            System.out.print("Enter height (m) for person " + (i+1) + ": ");
            personData[i][1] = sc.nextDouble();

            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);

            if (personData[i][2] < 18.5) weightStatus[i] = "Underweight";
            else if (personData[i][2] < 25) weightStatus[i] = "Normal";
            else if (personData[i][2] < 30) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }

        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i+1) + ": Height=" + personData[i][1] +
                               "m, Weight=" + personData[i][0] + "kg, BMI=" + personData[i][2] +
                               ", Status=" + weightStatus[i]);
        }

        sc.close();
    }
}

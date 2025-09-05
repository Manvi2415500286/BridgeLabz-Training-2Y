import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI and status
    public static String[] calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0;  // convert cm to meters
        double bmi = weight / (heightM * heightM);

        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 24.9) {
            status = "Normal";
        } else if (bmi < 29.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[] {
                String.format("%.2f", weight),
                String.format("%.2f", heightCm),
                String.format("%.2f", bmi),
                status
        };
    }

    // Method to compute BMI for all members
    public static String[][] processBMI(double[][] data) {
        String[][] result = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            result[i] = calculateBMI(data[i][0], data[i][1]);
        }
        return result;
    }

    // Method to display the results in tabular form
    public static void display(String[][] result) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Weight(kg)", "Height(cm)", "BMI", "Status");
        System.out.println("----------------------------------------------------------");
        for (String[] row : result) {
            System.out.printf("%-10s %-10s %-10s %-15s\n", row[0], row[1], row[2], row[3]);
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] members = new double[10][2]; // 10 members, [weight, height]

        // Taking input
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Person " + (i + 1));
            System.out.print("Weight (kg): ");
            members[i][0] = sc.nextDouble();
            System.out.print("Height (cm): ");
            members[i][1] = sc.nextDouble();
        }

        // Processing and Display
        String[][] result = processBMI(members);
        display(result);

        sc.close();
    }
}

import java.util.Scanner;

public class BMICalculator2 {

    public static double calculateBMI(double weightKg, double heightMeters) {
        return weightKg / (heightMeters * heightMeters);
    }

    public static String interpretBMI(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi >= 18.5 && bmi < 24.9) return "Normal weight";
        else if (bmi >= 25 && bmi < 29.9) return "Overweight";
        else return "Obesity";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter weight (kg): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter height (m): ");
        double height = scanner.nextDouble();

        double bmi = calculateBMI(weight, height);
        String category = interpretBMI(bmi);

        System.out.printf("Your BMI is %.2f, which is categorized as: %s%n", bmi, category);

        scanner.close();
    }
}

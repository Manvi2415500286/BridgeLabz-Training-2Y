import java.util.Scanner;

public class TriangularParksRun {
    public static int calculateRounds(double side1, double side2, double side3, double targetDistanceMeters) {
        double perimeter = side1 + side2 + side3;
        return (int) Math.ceil(targetDistanceMeters / perimeter);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter side1 of the triangle (meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter side2 of the triangle (meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter side3 of the triangle (meters): ");
        double side3 = scanner.nextDouble();

        double targetDistance = 5000.0;  // 5 km in meters

        int rounds = calculateRounds(side1, side2, side3, targetDistance);

        System.out.printf("The athlete must complete %d round(s) to cover 5 km.%n", rounds);

        scanner.close();
    }
}

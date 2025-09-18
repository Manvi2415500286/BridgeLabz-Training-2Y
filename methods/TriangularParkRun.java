import java.util.Scanner;

public class TriangularParkRun {

    public static int calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double distanceToRun = 5000; // meters
        return (int) Math.ceil(distanceToRun / perimeter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Side 1 in meters: ");
        double side1 = sc.nextDouble();
        System.out.print("Enter Side 2 in meters: ");
        double side2 = sc.nextDouble();
        System.out.print("Enter Side 3 in meters: ");
        double side3 = sc.nextDouble();

        int rounds = calculateRounds(side1, side2, side3);
        System.out.println("Athlete must complete " + rounds + " rounds to complete 5 km run.");
    }
}

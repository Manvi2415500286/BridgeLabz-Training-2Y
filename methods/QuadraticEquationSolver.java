import java.util.Scanner;

public class QuadraticEquationSolver {

    public static void solveQuadratic(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;

        if (a == 0) {
            System.out.println("This is not a quadratic equation.");
            return;
        }

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.printf("Two real and distinct roots: %.2f and %.2f%n", root1, root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.printf("Two real and equal roots: %.2f and %.2f%n", root, root);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.printf("Complex roots: %.2f + %.2fi and %.2f - %.2fi%n",
                    realPart, imaginaryPart, realPart, imaginaryPart);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();

        solveQuadratic(a, b, c);

        scanner.close();
    }
}

import java.util.Scanner;

public class LineEquationDistance {

    public static double findDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        return new double[]{m, b};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x1 y1: ");
        double x1 = sc.nextDouble(), y1 = sc.nextDouble();
        System.out.print("Enter x2 y2: ");
        double x2 = sc.nextDouble(), y2 = sc.nextDouble();

        double dist = findDistance(x1, y1, x2, y2);
        double[] eq = findLineEquation(x1, y1, x2, y2);

        System.out.printf("Euclidean Distance = %.3f%n", dist);
        System.out.printf("Equation of Line: y = %.3fx + %.3f%n", eq[0], eq[1]);
    }
}

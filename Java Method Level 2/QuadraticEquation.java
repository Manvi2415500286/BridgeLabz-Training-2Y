import java.util.Scanner;

public class QuadraticEquation {

    public static double[] findRoots(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        if (delta < 0) return new double[]{};

        double sqrtDelta = Math.sqrt(delta);
        if (delta == 0)
            return new double[]{-b / (2 * a)};
        else
            return new double[]{
                (-b + sqrtDelta) / (2 * a),
                (-b - sqrtDelta) / (2 * a)
            };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter coefficients a, b, c: ");
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();

        double[] roots = findRoots(a, b, c);
        if (roots.length == 0)
            System.out.println("No real roots (delta < 0)");
        else if (roots.length == 1)
            System.out.println("One root: " + roots[0]);
        else
            System.out.println("Two roots: " + roots[0] + " and " + roots[1]);
    }
}

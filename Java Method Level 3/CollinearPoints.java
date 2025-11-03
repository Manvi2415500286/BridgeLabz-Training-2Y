import java.util.Scanner;

public class CollinearPoints {

    // slope check using cross-multiplication to avoid division by zero:
    // (y2 - y1)/(x2 - x1) == (y3 - y2)/(x3 - x2)
    // -> (y2 - y1)*(x3 - x2) == (y3 - y2)*(x2 - x1)
    public static boolean areCollinearBySlope(double x1, double y1,
                                              double x2, double y2,
                                              double x3, double y3) {
        double lhs = (y2 - y1) * (x3 - x2);
        double rhs = (y3 - y2) * (x2 - x1);
        double eps = 1e-9;
        return Math.abs(lhs - rhs) < eps;
    }

    // area method: area = 0.5 * (x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2))
    public static boolean areCollinearByArea(double x1, double y1,
                                             double x2, double y2,
                                             double x3, double y3) {
        double area = 0.5 * (x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2));
        return Math.abs(area) < 1e-9;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter coordinates of point A (x1 y1):");
        double x1 = sc.nextDouble(), y1 = sc.nextDouble();

        System.out.println("Enter coordinates of point B (x2 y2):");
        double x2 = sc.nextDouble(), y2 = sc.nextDouble();

        System.out.println("Enter coordinates of point C (x3 y3):");
        double x3 = sc.nextDouble(), y3 = sc.nextDouble();

        boolean slopeResult = areCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean areaResult = areCollinearByArea(x1, y1, x2, y2, x3, y3);

        System.out.println("Collinear by slope method? " + slopeResult);
        System.out.println("Collinear by area method?  " + areaResult);

        if (slopeResult && areaResult) System.out.println("Points are collinear.");
        else System.out.println("Points are NOT collinear.");
    }
}

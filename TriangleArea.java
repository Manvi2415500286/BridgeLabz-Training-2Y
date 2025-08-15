import java.util.Scanner;

class TriangleArea {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        // Constant for conversion
        double CM_PER_INCH = 2.54;
        
        // Input base and height
        System.out.print("Enter base in cm: ");
        double base = input.nextDouble();
        
        System.out.print("Enter height in cm: ");
        double height = input.nextDouble();
        
        // Calculate areas
        double areaSqCm = 0.5 * base * height;
        double areaSqIn = areaSqCm / (CM_PER_INCH * CM_PER_INCH);
        
        // Output results
        System.out.println("The Area of the triangle in sq in is " + areaSqIn + " and sq cm is " + areaSqCm);
        
        input.close();
    }
}


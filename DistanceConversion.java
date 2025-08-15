import java.util.Scanner;

class DistanceConversion {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        // Conversion constants
        double FEET_PER_YARD = 3.0;
        double YARDS_PER_MILE = 1760.0;
        
        // Input
        System.out.print("Enter distance in feet: ");
        double distanceFeet = input.nextDouble();
        
        // Calculations
        double distanceYards = distanceFeet / FEET_PER_YARD;
        double distanceMiles = distanceYards / YARDS_PER_MILE;
        
        // Output
        System.out.println("The distance in yards is " + distanceYards + " while the distance in miles is " + distanceMiles);
        
        input.close();
    }
}

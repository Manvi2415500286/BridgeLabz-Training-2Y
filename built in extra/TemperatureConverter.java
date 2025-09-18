import java.util.Scanner;

public class TemperatureConverter {

    public static double celsiusToFahrenheit(double c) {
        return (c * 9/5) + 32;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5/9;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();
        System.out.print("Convert to (C/F): ");
        char unit = sc.next().toUpperCase().charAt(0);
        if (unit == 'C') System.out.println("Temperature in Celsius: " + fahrenheitToCelsius(temp));
        else if (unit == 'F') System.out.println("Temperature in Fahrenheit: " + celsiusToFahrenheit(temp));
        else System.out.println("Invalid unit");
    }
}

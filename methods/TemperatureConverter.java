import java.util.Scanner;

public class TemperatureConverter {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = celsiusToFahrenheit(celsius);
        System.out.printf("%.2f Celsius is %.2f Fahrenheit%n", celsius, fahrenheit);

        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheitInput = scanner.nextDouble();
        double celsiusOutput = fahrenheitToCelsius(fahrenheitInput);
        System.out.printf("%.2f Fahrenheit is %.2f Celsius%n", fahrenheitInput, celsiusOutput);

        scanner.close();
    }
}

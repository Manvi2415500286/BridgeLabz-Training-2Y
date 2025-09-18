import java.util.Scanner;

public class NumberPropertiesChecker {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isArmstrong(int number) {
        int original = number;
        int sum = 0;
        int digits = String.valueOf(number).length();

        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }

        return sum == original;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to check properties: ");
        int number = scanner.nextInt();

        System.out.println(number + " is " + (isEven(number) ? "Even" : "Odd"));
        System.out.println(number + (isPrime(number) ? " is Prime." : " is not Prime."));
        System.out.println(number + (isArmstrong(number) ? " is an Armstrong Number." : " is not an Armstrong Number."));

        scanner.close();
    }
}

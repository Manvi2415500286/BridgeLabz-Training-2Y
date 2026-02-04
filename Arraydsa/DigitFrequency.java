import java.util.Scanner;

class DigitFrequency {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Validate input
        if (number < 0) {
            System.out.println("Invalid number.");
            scanner.close();
            System.exit(0);
        }

        int[] frequency = new int[10];

        // Count digit frequency
        while (number > 0) {
            int digit = number % 10;
            frequency[digit]++;
            number /= 10;
        }

        // Display frequency
        System.out.println("Digit Frequency:");
        for (int digit = 0; digit < frequency.length; digit++) {
            System.out.println(digit + " : " + frequency[digit]);
        }

        scanner.close();
    }
}

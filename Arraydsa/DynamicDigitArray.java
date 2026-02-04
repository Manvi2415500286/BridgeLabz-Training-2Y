import java.util.Scanner;

class DynamicDigitArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int maxDigit = 10;
        int[] digits = new int[maxDigit];

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int index = 0;

        while (number != 0) {

            if (index == maxDigit) {

                maxDigit += 10;
                int[] temp = new int[maxDigit];

                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }

                digits = temp;
            }

            digits[index] = number % 10;
            number /= 10;
            index++;
        }

        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < index; i++) {

            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + secondLargest);

        scanner.close();
    }
}

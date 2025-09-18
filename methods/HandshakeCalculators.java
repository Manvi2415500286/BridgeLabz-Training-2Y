import java.util.Scanner;

public class HandshakeCalculators {
    public static int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();

        int handshakes = calculateHandshakes(numberOfStudents);
        System.out.printf("The maximum number of handshakes among %d students is %d%n",
                numberOfStudents, handshakes);

        scanner.close();
    }
}

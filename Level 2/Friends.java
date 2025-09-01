
import java.util.Scanner;

public class Friends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age of Amar: ");
        int ageAmar = sc.nextInt();
        System.out.print("Enter height of Amar (cm): ");
        int heightAmar = sc.nextInt();

        System.out.print("Enter age of Akbar: ");
        int ageAkbar = sc.nextInt();
        System.out.print("Enter height of Akbar (cm): ");
        int heightAkbar = sc.nextInt();

        System.out.print("Enter age of Anthony: ");
        int ageAnthony = sc.nextInt();
        System.out.print("Enter height of Anthony (cm): ");
        int heightAnthony = sc.nextInt();

        // Youngest
        if (ageAmar < ageAkbar && ageAmar < ageAnthony) {
            System.out.println("Youngest is Amar with age " + ageAmar);
        } else if (ageAkbar < ageAnthony) {
            System.out.println("Youngest is Akbar with age " + ageAkbar);
        } else {
            System.out.println("Youngest is Anthony with age " + ageAnthony);
        }

        // Tallest
        if (heightAmar > heightAkbar && heightAmar > heightAnthony) {
            System.out.println("Tallest is Amar with height " + heightAmar);
        } else if (heightAkbar > heightAnthony) {
            System.out.println("Tallest is Akbar with height " + heightAkbar);
        } else {
            System.out.println("Tallest is Anthony with height " + heightAnthony);
        }
    }
}

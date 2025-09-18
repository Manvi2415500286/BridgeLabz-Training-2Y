import java.util.Scanner;

public class SpringSeasonChecker2 {

    public static boolean isSpringSeason(int month, int day) {
        if ((month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter day (1-31): ");
        int day = scanner.nextInt();

        if (isSpringSeason(month, day)) {
            System.out.println("It's Spring Season");
        } else {
            System.out.println("It's not Spring Season");
        }

        scanner.close();
    }
}

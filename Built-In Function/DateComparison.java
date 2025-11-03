import java.time.*;
import java.util.*;

public class DateComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first date (yyyy-MM-dd): ");
        LocalDate d1 = LocalDate.parse(sc.nextLine());
        System.out.print("Enter second date (yyyy-MM-dd): ");
        LocalDate d2 = LocalDate.parse(sc.nextLine());

        if (d1.isBefore(d2))
            System.out.println("First date is before the second date.");
        else if (d1.isAfter(d2))
            System.out.println("First date is after the second date.");
        else
            System.out.println("Both dates are equal.");
    }
}

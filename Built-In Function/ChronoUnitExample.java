import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ChronoUnitExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first date (yyyy-MM-dd): ");
        LocalDate d1 = LocalDate.parse(sc.nextLine());
        System.out.print("Enter second date (yyyy-MM-dd): ");
        LocalDate d2 = LocalDate.parse(sc.nextLine());

        long days = ChronoUnit.DAYS.between(d1, d2);
        long months = ChronoUnit.MONTHS.between(d1, d2);
        long years = ChronoUnit.YEARS.between(d1, d2);

        System.out.println("Difference in Years: " + years);
        System.out.println("Difference in Months: " + months);
        System.out.println("Difference in Days: " + days);
    }
}

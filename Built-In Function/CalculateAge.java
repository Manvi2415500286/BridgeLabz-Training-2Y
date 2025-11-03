import java.time.*;
import java.util.*;

public class CalculateAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your birth date (yyyy-MM-dd): ");
        LocalDate birthDate = LocalDate.parse(sc.nextLine());
        LocalDate today = LocalDate.now();

        Period age = Period.between(birthDate, today);

        System.out.println("Your Age: " + age.getYears() + " years, " 
                + age.getMonths() + " months, and " + age.getDays() + " days.");
    }
}

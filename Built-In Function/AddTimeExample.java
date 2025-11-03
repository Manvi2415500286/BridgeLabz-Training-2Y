import java.time.*;

public class AddTimeExample {
    public static void main(String[] args) {
        LocalTime current = LocalTime.now();
        LocalTime updated = current.plusHours(5).plusMinutes(30);

        System.out.println("Current Time: " + current);
        System.out.println("After Adding 5 hours 30 minutes: " + updated);
    }
}

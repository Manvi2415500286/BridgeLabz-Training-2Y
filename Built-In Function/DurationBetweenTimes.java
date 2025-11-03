import java.time.*;
import java.util.*;

public class DurationBetweenTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter start time (HH:mm:ss): ");
        LocalTime start = LocalTime.parse(sc.nextLine());
        System.out.print("Enter end time (HH:mm:ss): ");
        LocalTime end = LocalTime.parse(sc.nextLine());

        Duration duration = Duration.between(start, end);

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        System.out.println("Duration: " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds.");
    }
}

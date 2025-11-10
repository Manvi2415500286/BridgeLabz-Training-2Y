import java.util.*;

public class AttendanceTracker {
    public static void main(String[] args) {
        Map<String, Integer> att = new HashMap<>();
        List<String> students = List.of("Aman", "Riya", "Karan", "Meena", "John");

        for (String s : students) att.put(s, 0);

        List<String[]> days = List.of(
            new String[]{"Aman", "Riya"},
            new String[]{"Aman", "John"},
            new String[]{"Riya", "Meena"}
        );

        for (String[] present : days) {
            for (String p : present) {
                att.put(p, att.get(p) + 1);
            }
        }

        att.forEach((s, c) -> {
            if (c < 2) System.out.println("Low attendance: " + s);
        });
    }
}

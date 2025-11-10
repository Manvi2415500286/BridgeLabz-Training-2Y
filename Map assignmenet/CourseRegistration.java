import java.util.*;

public class CourseRegistration {
    public static void main(String[] args) {
        Map<String, Integer> courses = new HashMap<>();

        courses.put("CS101", 45);
        courses.put("CS102", 4);
        courses.put("CS103", 55);

        // Add or drop
        courses.put("CS101", courses.get("CS101") + 5);
        courses.put("CS102", Math.max(0, courses.get("CS102") - 2));

        // Near full
        courses.forEach((c, v) -> {
            if (v >= 50) System.out.println("Near full: " + c);
            if (v < 5) System.out.println("Low: " + c);
        });
    }
}

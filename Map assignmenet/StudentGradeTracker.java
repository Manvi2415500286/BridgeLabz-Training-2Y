import java.util.*;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Map<String, Double> grades = new TreeMap<>();

        // Add students
        grades.put("Aman", 85.0);
        grades.put("Riya", 90.0);
        grades.put("Karan", 72.0);

        // Update grade
        grades.put("Aman", 88.0);

        // Remove student
        grades.remove("Karan");

        // Print sorted by name
        for (var e : grades.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }
    }
}

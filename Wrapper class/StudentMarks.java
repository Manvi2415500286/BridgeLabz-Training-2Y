import java.util.*;

public class StudentMarks {
    public static void main(String[] args) {
        String[] inputs = {"85", "95", "null", "abc"};
        ArrayList<Integer> validMarks = new ArrayList<>();

        for (String str : inputs) {
            try {
                validMarks.add(Integer.parseInt(str));
            } catch (Exception e) {
                // ignore invalid
            }
        }

        double avg = validMarks.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("Average marks: " + avg);
    }
}

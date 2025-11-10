import java.util.*;

public class VisitTracker {
    public static void main(String[] args) {
        Map<String, Integer> visits = new HashMap<>();

        String[] pages = {
                "home", "about", "products", "home",
                "products", "contact", "home"
        };

        for (String p : pages) {
            visits.put(p, visits.getOrDefault(p, 0) + 1);
        }

        // sort by visits descending
        visits.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);

        // most visited
        String most = Collections.max(visits.entrySet(),
                        Map.Entry.comparingByValue())
                        .getKey();
        System.out.println("Most visited: " + most);
    }
}

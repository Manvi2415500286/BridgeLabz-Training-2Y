import java.util.*;

public class VotingCount {
    public static void main(String[] args) {
        Map<String, Integer> votes = new HashMap<>();

        String[] cast = {
            "A", "B", "A", "C", "B", "A", "B", "C", "A", "B"
        };

        for (String v : cast) {
            votes.put(v, votes.getOrDefault(v, 0) + 1);
        }

        System.out.println("Votes: " + votes);
        String winner = Collections.max(votes.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Winner: " + winner);
    }
}

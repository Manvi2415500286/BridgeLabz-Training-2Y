public class GameScores {
    public static void main(String[] args) {
        Integer[] scores = {100, null, 200, null, 150};

        int nullCount = 0, total = 0;
        for (Integer score : scores) {
            if (score == null) nullCount++;
            else total += score;
        }

        System.out.println("Players not played: " + nullCount);
        System.out.println("Total valid score: " + total);
    }
}

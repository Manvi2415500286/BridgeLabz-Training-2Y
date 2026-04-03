import java.util.*;

public class FirstNonRepeating {
    public static void process(String stream) {
        Queue<Character> q = new LinkedList<>();
        int[] freq = new int[26];

        for (char ch : stream.toCharArray()) {
            freq[ch - 'a']++;
            q.add(ch);

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            if (q.isEmpty())
                System.out.print("-1 ");
            else
                System.out.print(q.peek() + " ");
        }
    }
}
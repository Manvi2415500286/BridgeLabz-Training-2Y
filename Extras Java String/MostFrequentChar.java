import java.util.*;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();

        int[] freq = new int[256];
        for (char ch : str.toCharArray())
            freq[ch]++;

        char maxChar = ' ';
        int maxCount = 0;

        for (int i = 0; i < 256; i++) {
            if (freq[i] > maxCount) {
                maxCount = freq[i];
                maxChar = (char) i;
            }
        }

        System.out.println("Most Frequent Character: '" + maxChar + "'");
    }
}

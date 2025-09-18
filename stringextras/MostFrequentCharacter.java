import java.util.Scanner;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] freq = new int[256];

        for (int i = 0; i < input.length(); i++) {
            freq[input.charAt(i)]++;
        }

        int max = -1;
        char mostFrequent = ' ';

        for (int i = 0; i < input.length(); i++) {
            if (freq[input.charAt(i)] > max) {
                max = freq[input.charAt(i)];
                mostFrequent = input.charAt(i);
            }
        }

        System.out.println("Most Frequent Character: '" + mostFrequent + "'");
    }
}

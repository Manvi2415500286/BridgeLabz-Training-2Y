import java.util.Scanner;

public class FrequencyCharASCII {

    public static String[][] findFrequency(String text) {
        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        String[][] result = new String[text.length()][2];
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (freq[c] != 0) {
                result[index][0] = String.valueOf(c);
                result[index][1] = String.valueOf(freq[c]);
                freq[c] = 0;
                index++;
            }
        }

        String[][] finalResult = new String[index][2];
        for (int i = 0; i < index; i++) {
            finalResult[i] = result[i];
        }
        return finalResult;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] freq = findFrequency(text);
        System.out.println("Character | Frequency");
        for (String[] row : freq) {
            System.out.println(row[0] + " -> " + row[1]);
        }

        sc.close();
    }
}

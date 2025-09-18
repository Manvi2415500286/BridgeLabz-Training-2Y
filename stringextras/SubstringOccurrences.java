import java.util.Scanner;

public class SubstringOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String sub = sc.nextLine();
        int count = 0;

        for (int i = 0; i <= text.length() - sub.length(); i++) {
            if (text.substring(i, i + sub.length()).equals(sub))
                count++;
        }

        System.out.println("Occurrences: " + count);
    }
}

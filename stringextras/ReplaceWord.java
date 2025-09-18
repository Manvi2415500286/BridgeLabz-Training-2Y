import java.util.Scanner;

public class ReplaceWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String target = sc.nextLine();
        String replacement = sc.nextLine();
        String result = "";

        int i = 0;
        while (i <= sentence.length() - target.length()) {
            if (sentence.substring(i, i + target.length()).equals(target)) {
                result += replacement;
                i += target.length();
            } else {
                result += sentence.charAt(i);
                i++;
            }
        }

        result += sentence.substring(i);
        System.out.println(result);
    }
}

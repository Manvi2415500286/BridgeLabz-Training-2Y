import java.util.Scanner;

public class UniqueCharacters {

    // Method to find length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); // will throw exception when index exceeds
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    // Method to find unique characters using charAt()
    public static char[] findUnique(String text) {
        int len = findLength(text);
        char[] unique = new char[len]; // maximum possible size
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            // check if this char already appeared
            for (int j = 0; j < i; j++) {
                if (current == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                unique[uniqueCount++] = current;
            }
        }

        // create final array with exact size
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }
        return result;
    }

    // Method to display unique characters
    public static void display(char[] arr) {
        System.out.print("Unique characters: ");
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char[] uniqueChars = findUnique(text);
        display(uniqueChars);

        sc.close();
    }
}

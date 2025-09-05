import java.util.Scanner;

public class SplitWordsDemo {
    public static int myLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    // User-defined split
    public static String[] mySplit(String str) {
        int len = myLength(str);
        int spaceCount = 1;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') spaceCount++;
        }

        String[] words = new String[spaceCount];
        int wordIndex = 0;
        String temp = "";
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                words[wordIndex++] = temp;
                temp = "";
            } else {
                temp += c;
            }
        }
        words[wordIndex] = temp;
        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] myArr = mySplit(text);
        String[] builtIn = text.split(" ");

        System.out.println("Arrays are equal? " + compareArrays(myArr, builtIn));
    }
}

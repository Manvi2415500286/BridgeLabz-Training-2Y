import java.util.Scanner;

public class ShortestLongestWord {
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

    public static String[] mySplit(String str) {
        int len = myLength(str);
        int spaceCount = 1;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') spaceCount++;
        }

        String[] words = new String[spaceCount];
        int idx = 0;
        String temp = "";
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                words[idx++] = temp;
                temp = "";
            } else {
                temp += c;
            }
        }
        words[idx] = temp;
        return words;
    }

    public static String findShortest(String[] words) {
        String shortest = words[0];
        for (String w : words) {
            if (myLength(w) < myLength(shortest)) shortest = w;
        }
        return shortest;
    }

    public static String findLongest(String[] words) {
        String longest = words[0];
        for (String w : words) {
            if (myLength(w) > myLength(longest)) longest = w;
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] words = mySplit(text);
        System.out.println("Shortest word: " + findShortest(words));
        System.out.println("Longest word: " + findLongest(words));
    }
}

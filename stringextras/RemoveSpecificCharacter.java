import java.util.Scanner;

public class RemoveSpecificCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char toRemove = sc.nextLine().charAt(0);
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != toRemove)
                result += input.charAt(i);
        }

        System.out.println("Modified String: " + result);
    }
}

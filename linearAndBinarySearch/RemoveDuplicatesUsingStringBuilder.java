import java.util.HashSet;

class RemoveDuplicatesUsingStringBuilder {
    public static void main(String[] args) {
        String input = "programming";

        // Step 1: Initialize StringBuilder and HashSet
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        // Step 2: Iterate through the string
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (!seen.contains(ch)) {
                seen.add(ch);
                sb.append(ch);
            }
        }

        // Step 3: Convert to string
        String result = sb.toString();

        System.out.println("Original String: " + input);
        System.out.println("String without duplicates: " + result);
    }
}

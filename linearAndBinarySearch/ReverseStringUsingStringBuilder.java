class ReverseStringUsingStringBuilder {
    public static void main(String[] args) {
        String input = "hello";

        // Step 1 & 2: Create StringBuilder and append string
        StringBuilder sb = new StringBuilder();
        sb.append(input);

        // Step 3: Reverse the string
        sb.reverse();

        // Step 4: Convert back to String
        String reversedString = sb.toString();

        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reversedString);
    }
}

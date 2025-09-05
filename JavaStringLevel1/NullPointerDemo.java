public class NullPointerDemo {
    // Method to generate exception
    public static void generateNPE() {
        String text = null;
        System.out.println(text.length()); // Throws NullPointerException
    }

    // Method with try-catch
    public static void handleNPE() {
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e);
        }
    }

    public static void main(String[] args) {
        // generateNPE(); // Uncomment to see abrupt crash
        handleNPE();
    }
}

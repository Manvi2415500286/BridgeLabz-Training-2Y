public class WrapperComparison {
    public static void main(String[] args) {
        Integer a = 100, b = 100;
        Integer c = 200, d = 200;

        System.out.println("a == b: " + (a == b));
        System.out.println("c == d: " + (c == d));
        System.out.println("a.equals(b): " + a.equals(b));

        /*
         * Explanation:
         * Integer values between -128 to 127 are cached,
         * so a and b refer to the same object.
         * c and d are different objects, hence '==' is false.
         * equals() checks values, so it's true for equal numbers.
         */
    }
}

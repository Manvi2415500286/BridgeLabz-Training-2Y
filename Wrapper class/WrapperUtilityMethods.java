public class WrapperUtilityMethods {
    public static void main(String[] args) {
        int num = Integer.parseInt("123");
        double d = Double.parseDouble("3.14");
        boolean bool = Boolean.parseBoolean("true");
        String binary = Integer.toBinaryString(10);
        boolean isDigit = Character.isDigit('5');
        char upper = Character.toUpperCase('a');

        System.out.println("Parsed int: " + num);
        System.out.println("Parsed double: " + d);
        System.out.println("Parsed boolean: " + bool);
        System.out.println("Binary of 10: " + binary);
        System.out.println("Is '5' a digit? " + isDigit);
        System.out.println("Uppercase of 'a': " + upper);
    }
}

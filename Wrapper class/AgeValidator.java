public class AgeValidator {
    public static boolean validateAge(String input) {
        try {
            int age = Integer.parseInt(input);
            return age >= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validateAge("20"));  // true
        System.out.println(validateAge("abc")); // false
        System.out.println(validateAge("16"));  // false
    }
}

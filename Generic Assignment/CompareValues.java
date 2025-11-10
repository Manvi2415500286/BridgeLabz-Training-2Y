public class CompareValues {
    public static <T> boolean isEqual(T a, T b) {
        return a == null ? b == null : a.equals(b);
    }

    public static void main(String[] args) {
        System.out.println(isEqual(10, 10));
        System.out.println(isEqual("Hi", "Hi"));
        System.out.println(isEqual(5.5, 5.6));
    }
}

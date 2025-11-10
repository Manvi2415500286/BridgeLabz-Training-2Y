public class MaximumOfThree {
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x.compareTo(y) >= 0 ? x : y;
        return max.compareTo(z) >= 0 ? max : z;
    }

    public static void main(String[] args) {
        System.out.println(maximum(3, 9, 5));
        System.out.println(maximum("Apple", "Boy", "Cat"));
    }
}

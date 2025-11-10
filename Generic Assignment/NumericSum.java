import java.util.*;

public class NumericSum {
    public static double sumNumbers(List<? extends Number> list) {
        return list.stream().mapToDouble(Number::doubleValue).sum();
    }

    public static void main(String[] args) {
        System.out.println(sumNumbers(List.of(1, 2, 3)));
        System.out.println(sumNumbers(List.of(1.5, 2.5, 3.5)));
    }
}

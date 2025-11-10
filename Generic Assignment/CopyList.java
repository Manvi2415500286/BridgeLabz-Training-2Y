import java.util.*;

public class CopyList {
    public static void copyList(List<? super Number> dest, List<? extends Number> src) {
        dest.addAll(src);
    }

    public static void main(String[] args) {
        List<Number> dest = new ArrayList<>();
        List<Integer> src = List.of(10, 20, 30);

        copyList(dest, src);
        System.out.println(dest);
    }
}

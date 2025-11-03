import java.util.ArrayList;

public class WrapperPerformance {
    public static void main(String[] args) {
        int size = 1_000_000;

        // Primitive array
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i;

        // Wrapper ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) list.add(i);

        long start1 = System.currentTimeMillis();
        long sum1 = 0;
        for (int n : arr) sum1 += n;
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        long sum2 = 0;
        for (Integer n : list) sum2 += n;
        long end2 = System.currentTimeMillis();

        System.out.println("Sum with int[]: " + sum1 + " (Time: " + (end1 - start1) + "ms)");
        System.out.println("Sum with ArrayList<Integer>: " + sum2 + " (Time: " + (end2 - start2) + "ms)");
    }
}

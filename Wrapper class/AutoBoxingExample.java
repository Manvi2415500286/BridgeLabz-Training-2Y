import java.util.ArrayList;

public class AutoBoxingExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // Auto-boxing
        for (int i = 1; i <= 10; i++) {
            list.add(i * 5); 
        }

        int sum = 0;
        // Auto-unboxing
        for (Integer val : list) {
            sum += val;
        }

        System.out.println("Sum of numbers = " + sum);
    }
}

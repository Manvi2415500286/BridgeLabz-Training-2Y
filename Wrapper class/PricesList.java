import java.util.*;

public class PricesList {
    public static void main(String[] args) {
        double[] prices = {10.5, 20.0, 35.75, 5.5};

        ArrayList<Double> list = new ArrayList<>();
        for (double p : prices) list.add(p); // auto-boxing

        double sum = 0;
        for (double val : list) sum += val; // auto-unboxing

        double avg = sum / list.size();
        double max = Collections.max(list);

        System.out.println("Highest price: " + max);
        System.out.println("Average price: " + avg);
    }
}

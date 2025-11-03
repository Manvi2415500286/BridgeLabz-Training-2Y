import java.util.*;

public class FootballTeamStats {
    public static void main(String[] args) {
        int[] heights = new int[11];
        Random rand = new Random();
        for (int i = 0; i < heights.length; i++)
            heights[i] = rand.nextInt(101) + 150; // 150–250 cm

        int sum = findSum(heights);
        double mean = findMean(heights);
        int min = findMin(heights);
        int max = findMax(heights);

        System.out.println("Heights: " + Arrays.toString(heights));
        System.out.println("Shortest: " + min + " cm");
        System.out.println("Tallest: " + max + " cm");
        System.out.println("Mean height: " + String.format("%.2f", mean) + " cm");
    }

    public static int findSum(int[] a) {
        int s = 0; for (int v : a) s += v; return s;
    }
    public static double findMean(int[] a) {
        return (double) findSum(a) / a.length;
    }
    public static int findMin(int[] a) {
        int m = a[0]; for (int v : a) if (v < m) m = v; return m;
    }
    public static int findMax(int[] a) {
        int m = a[0]; for (int v : a) if (v > m) m = v; return m;
    }
}

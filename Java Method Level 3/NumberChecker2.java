
public class NumberChecker2 {
    public static void main(String[] args) {
        int number = 1729;
        int[] digits = extractDigits(number);
        int sum = sumDigits(digits);
        int sumSq = sumSquares(digits);
        System.out.println("Sum of digits: " + sum);
        System.out.println("Sum of squares: " + sumSq);
        System.out.println("Is Harshad? " + isHarshad(number, sum));
        int[][] freq = findDigitFrequency(digits);
        System.out.println("Digit  Freq");
        for (int[] row : freq)
            if (row[1] > 0) System.out.println(row[0] + "\t" + row[1]);
    }

    public static int[] extractDigits(int n) {
        String s = String.valueOf(n);
        int[] d = new int[s.length()];
        for (int i = 0; i < s.length(); i++) d[i] = s.charAt(i) - '0';
        return d;
    }

    public static int sumDigits(int[] d) { int s = 0; for (int v : d) s += v; return s; }
    public static int sumSquares(int[] d) { int s = 0; for (int v : d) s += Math.pow(v, 2); return s; }
    public static boolean isHarshad(int n, int sum) { return n % sum == 0; }

    public static int[][] findDigitFrequency(int[] d) {
        int[][] f = new int[10][2];
        for (int i = 0; i < 10; i++) f[i][0] = i;
        for (int v : d) f[v][1]++;
        return f;
    }
}

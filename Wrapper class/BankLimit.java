public class BankLimit {
    public static double remainingLimit(Double limit) {
        if (limit == null) return 0.0;
        return limit - 1000.0; // Example: subtract some amount
    }

    public static void main(String[] args) {
        Double limit1 = 5000.0;
        Double limit2 = null;

        System.out.println("Remaining (limit1): " + remainingLimit(limit1));
        System.out.println("Remaining (limit2): " + remainingLimit(limit2));
    }
}

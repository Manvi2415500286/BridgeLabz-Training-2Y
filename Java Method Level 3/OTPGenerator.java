import java.util.HashSet;
import java.util.Set;

public class OTPGenerator {

    // returns a 6-digit OTP as int (100000..999999)
    public static int generate6DigitOTP() {
        return 100000 + (int)(Math.random() * 900000);
    }

    public static int[] generateMultipleOTPs(int count) {
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) arr[i] = generate6DigitOTP();
        return arr;
    }

    public static boolean areUnique(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for (int v : arr) s.add(v);
        return s.size() == arr.length;
    }

    public static void main(String[] args) {
        // generate 10 OTPs and validate uniqueness
        int[] otps = generateMultipleOTPs(10);
        System.out.println("Generated OTPs:");
        for (int otp : otps) System.out.println(otp);

        System.out.println("All unique? " + areUnique(otps));
        if (!areUnique(otps)) {
            System.out.println("Warning: duplicates detected — you can regenerate until unique.");
        }
    }
}

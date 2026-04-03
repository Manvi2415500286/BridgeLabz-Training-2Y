public class CircularTour {
    static int findStart(int[] petrol, int[] dist) {
        int start = 0, total = 0, curr = 0;

        for (int i = 0; i < petrol.length; i++) {
            int diff = petrol[i] - dist[i];

            total += diff;
            curr += diff;

            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }

        return (total >= 0) ? start : -1;
    }
}
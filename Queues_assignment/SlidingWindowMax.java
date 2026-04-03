import java.util.*;

public class SlidingWindowMax {
    public static void maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {

            // Remove out of window
            if (!dq.isEmpty() && dq.peek() == i - k) {
                dq.poll();
            }

            // Remove smaller elements
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            if (i >= k - 1) {
                System.out.print(arr[dq.peek()] + " ");
            }
        }
    }
}
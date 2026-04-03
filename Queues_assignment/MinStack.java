import java.util.*;

class MinStack {
    Stack<Integer> main = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int x) {
        main.push(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        if (main.pop().equals(min.peek())) {
            min.pop();
        }
    }

    public int getMin() {
        return min.peek();
    }
}
class CircularBuffer {
    int[] arr; int front = 0, size = 0;
    int capacity;

    CircularBuffer(int c) {
        arr = new int[c];
        capacity = c;
    }

    void add(int x) {
        int idx = (front + size) % capacity;
        arr[idx] = x;
        if (size < capacity) size++;
        else front = (front + 1) % capacity; // overwrite
    }
}

class MyHashMap {
    class Node {
        int key, value;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int SIZE = 10;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets[index];

        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public int get(int key) {
        int index = hash(key);
        Node head = buckets[index];

        while (head != null) {
            if (head.key == key) return head.value;
            head = head.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node head = buckets[index], prev = null;

        while (head != null) {
            if (head.key == key) {
                if (prev == null)
                    buckets[index] = head.next;
                else
                    prev.next = head.next;
                return;
            }
            prev = head;
            head = head.next;
        }
    }
}
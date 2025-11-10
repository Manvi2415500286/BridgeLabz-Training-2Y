public static <T> T nthFromEnd(LinkedList<T> list, int n) {
    Iterator<T> fast = list.iterator();
    Iterator<T> slow = list.iterator();

    for (int i = 0; i < n; i++) fast.next();

    while (fast.hasNext()) {
        fast.next();
        slow.next();
    }
    return slow.next();
}

public static <T> void rotate(List<T> list, int k) {
    k = k % list.size();
    List<T> temp = new ArrayList<>();

    for (int i = k; i < list.size(); i++) temp.add(list.get(i));
    for (int i = 0; i < k; i++) temp.add(list.get(i));

    list.clear();
    list.addAll(temp);
}

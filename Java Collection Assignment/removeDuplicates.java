public static <T> List<T> removeDuplicates(List<T> list) {
    Set<T> seen = new HashSet<>();
    List<T> result = new ArrayList<>();

    for (T val : list) {
        if (!seen.contains(val)) {
            seen.add(val);
            result.add(val);
        }
    }
    return result;
}

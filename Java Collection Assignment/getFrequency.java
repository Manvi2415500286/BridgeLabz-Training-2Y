public static Map<String, Integer> getFrequency(List<String> list) {
    Map<String, Integer> freq = new HashMap<>();
    for (String s : list) {
        freq.put(s, freq.getOrDefault(s, 0) + 1);
    }
    return freq;
}

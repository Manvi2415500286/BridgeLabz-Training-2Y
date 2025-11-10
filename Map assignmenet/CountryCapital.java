import java.util.*;

public class CountryCapital {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();

        map.put("India", "New Delhi");
        map.put("USA", "Washington");
        map.put("Japan", "Tokyo");
        map.put("France", "Paris");
        map.put("China", "Beijing");

        System.out.println(map);

        String country = "Japan";
        System.out.println(map.getOrDefault(country, "Unknown country"));
    }
}

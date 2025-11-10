import java.util.*;

public class LibraryCatalog {
    public static void main(String[] args) {
        Map<String, String> books = new TreeMap<>();

        books.put("978-1111111111", "Java Basics");
        books.put("978-2222222222", "Data Structures");

        // search by ISBN
        String isbn = "978-1111111111";
        System.out.println(books.getOrDefault(isbn, "Book not found"));

        // remove
        books.remove("978-2222222222");

        // sorted print
        books.forEach((k, v) -> System.out.println(k + " : " + v));

        // search by title
        String title = "Java Basics";
        for (var e : books.entrySet()) {
            if (e.getValue().equals(title)) System.out.println("Found ISBN: " + e.getKey());
        }
    }
}

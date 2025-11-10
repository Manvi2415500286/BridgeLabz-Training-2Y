import java.util.*;

class Employee {
    String name;
    String dept;

    Employee(String n, String d) { name = n; dept = d; }
}

public class GroupByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        Map<String, List<String>> map = new HashMap<>();

        for (Employee e : employees) {
            map.computeIfAbsent(e.dept, k -> new ArrayList<>()).add(e.name);
        }

        System.out.println(map);
    }
}

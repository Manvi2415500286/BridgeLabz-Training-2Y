import java.util.*;

class Employee {
    int id;
    String name;
    double salary;
    double bonus;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void calculateBonus() {
        if (salary > 80000)
            bonus = salary * 0.1;
        else if (salary > 50000)
            bonus = salary * 0.07;
        else
            bonus = salary * 0.05;
    }

    public void display() {
        System.out.printf("ID: %d, Name: %s, Salary: %.2f, Bonus: %.2f, Total: %.2f%n",
                id, name, salary, bonus, (salary + bonus));
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        Employee[] emp = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter ID, Name, Salary: ");
            int id = sc.nextInt();
            String name = sc.next();
            double sal = sc.nextDouble();
            emp[i] = new Employee(id, name, sal);
            emp[i].calculateBonus();
        }

        System.out.println("\nEmployee Details:");
        for (Employee e : emp)
            e.display();
    }
}

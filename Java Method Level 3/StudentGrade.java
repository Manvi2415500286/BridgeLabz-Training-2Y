import java.util.*;

class Student {
    int rollNo;
    String name;
    double marks1, marks2, marks3, avg;
    char grade;

    public void inputData(Scanner sc) {
        System.out.print("Enter RollNo, Name, Marks1, Marks2, Marks3: ");
        rollNo = sc.nextInt();
        name = sc.next();
        marks1 = sc.nextDouble();
        marks2 = sc.nextDouble();
        marks3 = sc.nextDouble();
    }

    public void calculateGrade() {
        avg = (marks1 + marks2 + marks3) / 3;
        if (avg >= 85) grade = 'A';
        else if (avg >= 70) grade = 'B';
        else if (avg >= 50) grade = 'C';
        else grade = 'F';
    }

    public void display() {
        System.out.printf("RollNo: %d, Name: %s, Avg: %.2f, Grade: %c%n",
                rollNo, name, avg, grade);
    }
}

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        s.inputData(sc);
        s.calculateGrade();
        s.display();
    }
}

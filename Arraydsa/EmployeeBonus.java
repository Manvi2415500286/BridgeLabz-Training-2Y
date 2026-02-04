import java.util.Scanner;

class EmployeeBonus {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int totalEmployees = 10;

        double[] salary = new double[totalEmployees];
        double[] yearsOfService = new double[totalEmployees];
        double[] bonus = new double[totalEmployees];
        double[] newSalary = new double[totalEmployees];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        // Input salary and years of service
        for (int index = 0; index < totalEmployees; index++) {

            System.out.print("Enter salary for employee " + (index + 1) + ": ");
            salary[index] = scanner.nextDouble();

            System.out.print("Enter years of service for employee " + (index + 1) + ": ");
            yearsOfService[index] = scanner.nextDouble();

            // Validate input
            if (salary[index] <= 0 || yearsOfService[index] < 0) {
                System.out.println("Invalid input. Please re-enter.");
                index--;
                continue;
            }
        }

        // Calculate bonus and new salary
        for (int index = 0; index < totalEmployees; index++) {

            if (yearsOfService[index] > 5) {
                bonus[index] = salary[index] * 0.05;
            } else {
                bonus[index] = salary[index] * 0.02;
            }

            newSalary[index] = salary[index] + bonus[index];

            totalBonus += bonus[index];
            totalOldSalary += salary[index];
            totalNewSalary += newSalary[index];
        }

        // Display totals
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Paid: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);

        scanner.close();
    }
}

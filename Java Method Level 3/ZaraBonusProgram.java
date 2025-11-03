import java.util.Random;

public class ZaraBonusProgram {

    public static double[][] generateSalaryAndService(int employees) {
        double[][] data = new double[employees][2]; // [][0]=salary, [][1]=years
        Random r = new Random();
        for (int i = 0; i < employees; i++) {
            data[i][0] = 10000 + r.nextInt(90000); // 5-digit salary
            data[i][1] = 1 + r.nextInt(10);         // 1–10 yrs service
        }
        return data;
    }

    public static double[][] calculateNewSalary(double[][] oldData) {
        double[][] newData = new double[oldData.length][2]; // [][0]=new salary, [][1]=bonus
        for (int i = 0; i < oldData.length; i++) {
            double sal = oldData[i][0];
            double yrs = oldData[i][1];
            double bonusRate = (yrs > 5) ? 0.05 : 0.02;
            double bonus = sal * bonusRate;
            newData[i][0] = sal + bonus;
            newData[i][1] = bonus;
        }
        return newData;
    }

    public static void displayReport(double[][] oldData, double[][] newData) {
        double totalOld = 0, totalNew = 0, totalBonus = 0;
        System.out.println("Emp\tSalary\tYears\tNewSalary\tBonus");
        for (int i = 0; i < oldData.length; i++) {
            totalOld  += oldData[i][0];
            totalNew  += newData[i][0];
            totalBonus+= newData[i][1];
            System.out.printf("%d\t%.0f\t%.0f\t%.0f\t\t%.0f%n",
                    i+1, oldData[i][0], oldData[i][1], newData[i][0], newData[i][1]);
        }
        System.out.println("---------------------------------------------");
        System.out.printf("Total Old Salary: %.0f%n", totalOld);
        System.out.printf("Total New Salary: %.0f%n", totalNew);
        System.out.printf("Total Bonus Paid: %.0f%n", totalBonus);
    }

    public static void main(String[] args) {
        double[][] oldData = generateSalaryAndService(10);
        double[][] newData = calculateNewSalary(oldData);
        displayReport(oldData, newData);
    }
}

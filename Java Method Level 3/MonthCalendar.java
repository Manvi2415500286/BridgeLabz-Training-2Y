import java.util.Scanner;

public class MonthCalendar {

    public static boolean isLeapYear(int year) {
        if (year < 1582) return false;
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static String getMonthName(int month) {
        String[] months = {"January","February","March","April","May","June",
                           "July","August","September","October","November","December"};
        if (month < 1 || month > 12) return "Invalid";
        return months[month - 1];
    }

    public static int getDaysInMonth(int month, int year) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (month == 2 && isLeapYear(year)) return 29;
        return days[month - 1];
    }

    // Zeller's congruence to get day of week for 1st day (0=Sunday..6=Saturday)
    public static int getFirstDayOfMonth(int month, int year) {
        int q = 1; // day of month
        int m = month;
        int Y = year;
        if (m == 1) { m = 13; Y = year - 1; }
        if (m == 2) { m = 14; Y = year - 1; }
        int K = Y % 100;
        int J = Y / 100;
        int h = (q + (13*(m + 1))/5 + K + K/4 + J/4 + 5*J) % 7;
        // h: 0=Saturday,1=Sunday,... convert to 0=Sunday
        int d = (h + 6) % 7;
        return d;
    }

    public static void printCalendar(int month, int year) {
        System.out.println("     " + getMonthName(month) + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");
        int firstDay = getFirstDayOfMonth(month, year);
        int days = getDaysInMonth(month, year);

        int current = 1;
        // indent
        for (int i = 0; i < firstDay; i++) System.out.print("   ");
        for (int d = firstDay; d < 7; d++) {
            System.out.printf("%2d ", current++);
            if (current > days) { System.out.println(); return; }
        }
        System.out.println();
        while (current <= days) {
            for (int i = 0; i < 7 && current <= days; i++) {
                System.out.printf("%2d ", current++);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        printCalendar(month, year);
    }
}

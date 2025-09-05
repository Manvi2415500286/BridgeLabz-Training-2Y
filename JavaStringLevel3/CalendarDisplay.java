import java.util.Scanner;

public class CalendarDisplay {

    static String[] months = {"", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    public static int getFirstDay(int month, int year) {
        int d = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        return (d + x + 31 * m0 / 12) % 7;
    }

    public static void displayCalendar(int month, int year) {
        if (month == 2 && isLeapYear(year)) days[month] = 29;

        System.out.println("   " + months[month] + " " + year);
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        int startDay = getFirstDay(month, year);

        for (int i = 0; i < startDay; i++) System.out.print("    ");

        for (int day = 1; day <= days[month]; day++) {
            System.out.printf("%4d", day);
            if (((day + startDay) % 7 == 0) || (day == days[month])) System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        displayCalendar(month, year);
        sc.close();
    }
}

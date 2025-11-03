import java.util.*;

class BankAccount {
    String accNo, name;
    double balance;

    public BankAccount(String accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amt) {
        balance += amt;
        System.out.println("Deposited: " + amt);
    }

    public void withdraw(double amt) {
        if (amt > balance)
            System.out.println("Insufficient Balance!");
        else {
            balance -= amt;
            System.out.println("Withdrawn: " + amt);
        }
    }

    public void showBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount acc = new BankAccount("A101", "Prince", 10000);

        System.out.println("1.Deposit  2.Withdraw  3.Check Balance  4.Exit");
        while (true) {
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> {
                    System.out.print("Enter amount: ");
                    acc.deposit(sc.nextDouble());
                }
                case 2 -> {
                    System.out.print("Enter amount: ");
                    acc.withdraw(sc.nextDouble());
                }
                case 3 -> acc.showBalance();
                case 4 -> { return; }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }
}

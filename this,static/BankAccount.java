class BankAccount {
    static String bankName = "MyBank";
    private static int totalAccounts = 0;

    private final int accountNumber;
    private String accountHolderName;

    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    public static void getTotalAccounts() {
        System.out.println("Total accounts: " + totalAccounts);
    }

    public void displayDetails(Object obj) {
        if (obj instanceof BankAccount) {
            BankAccount account = (BankAccount) obj;
            System.out.println("Bank Name: " + BankAccount.bankName);
            System.out.println("Account Holder: " + account.accountHolderName);
            System.out.println("Account Number: " + account.accountNumber);
        } else {
            System.out.println("The provided object is not a BankAccount instance.");
        }
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("John Doe", 1001);
        BankAccount account2 = new BankAccount("Jane Smith", 1002);

        System.out.println("--- Account Details ---");
        account1.displayDetails(account1);
        System.out.println();
        account2.displayDetails(account2);
        System.out.println();

        System.out.println("--- Total Accounts ---");
        BankAccount.getTotalAccounts();

        System.out.println();
        System.out.println("--- Checking instanceof with a non-account object ---");
        String notAnAccount = "This is a string";
        account1.displayDetails(notAnAccount);
    }
}

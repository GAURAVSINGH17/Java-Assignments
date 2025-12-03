public class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private String email;
    private String phoneNumber;

    public Account(int accountNumber, String name, double initialDeposit, String email, String phone) {
        this.accountNumber = accountNumber;
        this.accountHolderName = name;
        this.balance = initialDeposit;
        this.email = email;
        this.phoneNumber = phone;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive!");
            return;
        }
        balance += amount;
        System.out.println("Amount deposited successfully!");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive!");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawal successful!");
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void updateContactDetails(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("Contact details updated!");
    }
}

import java.util.Scanner;

public class UserInterface {
    private Account[] accounts = new Account[100];
    private int accountCount = 0;
    private int accountNumberGenerator = 1001;

    Scanner sc = new Scanner(System.in);

    public void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial deposit: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        Account acc = new Account(accountNumberGenerator++, name, amount, email, phone);
        accounts[accountCount++] = acc;

        System.out.println("Account created! Account Number: " + acc.getAccountNumber());
    }

    public Account findAccount(int accNo) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accNo)
                return accounts[i];
        }
        return null;
    }

    public void performDeposit() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();

        Account acc = findAccount(accNo);
        if (acc != null) acc.deposit(amt);
        else System.out.println("Account not found!");
    }

    public void performWithdrawal() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();

        Account acc = findAccount(accNo);
        if (acc != null) acc.withdraw(amt);
        else System.out.println("Account not found!");
    }

    public void showAccountDetails() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();

        Account acc = findAccount(accNo);
        if (acc != null) acc.displayAccountDetails();
        else System.out.println("Account not found!");
    }

    public void updateContact() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        Account acc = findAccount(accNo);

        if (acc != null) {
            System.out.print("Enter new email: ");
            String email = sc.nextLine();

            System.out.print("Enter new phone: ");
            String phone = sc.nextLine();

            acc.updateContactDetails(email, phone);
        } else {
            System.out.println("Account not found!");
        }
    }
}

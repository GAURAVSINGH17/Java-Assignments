import java.util.Scanner;

public class UserInterface {

    private Account[] accounts = new Account[100];
    private int accountCount = 0;

    private Scanner sc = new Scanner(System.in);

    private int generateAccountNumber() {
        return 1001 + accountCount; // starts from 1001
    }

    public void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial deposit amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // consume newline

        System.out.print("Enter email address: ");
        String email = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        int accNumber = generateAccountNumber();

        accounts[accountCount] = new Account(accNumber, name, amount, email, phone);
        accountCount++;

        System.out.println("Account created successfully with Account Number: " + accNumber);
    }

    public Account findAccount(int accNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    public void performDeposit() {
        System.out.print("Enter account number: ");
        int acc = sc.nextInt();

        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        Account a = findAccount(acc);
        if (a != null) {
            a.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void performWithdrawal() {
        System.out.print("Enter account number: ");
        int acc = sc.nextInt();

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        Account a = findAccount(acc);
        if (a != null) {
            a.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void showAccountDetails() {
        System.out.print("Enter account number: ");
        int acc = sc.nextInt();
        sc.nextLine();

        Account a = findAccount(acc);
        if (a != null) {
            a.displayAccountDetails();
        } else {
            System.out.println("Account not found!");
        }
    }

    public void updateContact() {
        System.out.print("Enter account number: ");
        int acc = sc.nextInt();
        sc.nextLine();

        Account a = findAccount(acc);
        if (a == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter new email: ");
        String email = sc.nextLine();

        System.out.print("Enter new phone number: ");
        String phone = sc.nextLine();

        a.updateContactDetails(email, phone);
    }

    public void mainMenu() {
        while (true) {
            System.out.println("\nWelcome to the Banking Application!");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: performDeposit(); break;
                case 3: performWithdrawal(); break;
                case 4: showAccountDetails(); break;
                case 5: updateContact(); break;
                case 6: 
                    System.out.println("Exiting program. Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.mainMenu();
    }
}

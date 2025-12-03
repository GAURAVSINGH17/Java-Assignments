import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Banking Application ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Details");
            System.out.println("5. Update Contact");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1: ui.createAccount(); break;
                case 2: ui.performDeposit(); break;
                case 3: ui.performWithdrawal(); break;
                case 4: ui.showAccountDetails(); break;
                case 5: ui.updateContact(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }
}

import java.util.Scanner;

public class ContactListApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        while (true) {
            System.out.println("\n===== CONTACT LIST APP =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    manager.addContact(name, phone, email);
                    break;

                case 2:
                    manager.viewContacts();
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    manager.searchContact(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter name to delete: ");
                    manager.deleteContact(sc.nextLine());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

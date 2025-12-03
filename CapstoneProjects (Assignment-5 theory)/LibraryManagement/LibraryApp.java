import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    lib.addBook(title, author);
                    break;

                case 2:
                    lib.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter title to search: ");
                    lib.searchBook(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter title to issue: ");
                    lib.issueBook(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter title to return: ");
                    lib.returnBook(sc.nextLine());
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

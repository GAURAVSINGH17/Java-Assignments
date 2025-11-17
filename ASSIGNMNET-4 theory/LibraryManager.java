import java.io.*;
import java.util.*;

public class LibraryManager {

    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, Member> members = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    // Constructor loads data from files
    public LibraryManager() {
        loadFromFile();
    }

    // Add Book
    public void addBook() {
        try {
            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (books.containsKey(id)) {
                System.out.println("Book ID already exists.");
                return;
            }

            System.out.print("Enter Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            System.out.print("Enter Category: ");
            String category = sc.nextLine();

            Book book = new Book(id, title, author, category);
            books.put(id, book);

            saveToFile();
            System.out.println("Book added successfully!");

        } catch (Exception e) {
            System.out.println("Error adding book.");
        }
    }

    // Add Member
    public void addMember() {
        try {
            System.out.print("Enter Member ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (members.containsKey(id)) {
                System.out.println("Member ID already exists.");
                return;
            }

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            if (!email.contains("@") || !email.contains(".")) {
                System.out.println("Invalid email format.");
                return;
            }

            Member m = new Member(id, name, email);
            members.put(id, m);

            saveToFile();
            System.out.println("Member added successfully!");

        } catch (Exception e) {
            System.out.println("Error adding member.");
        }
    }

    // Issue Book
    public void issueBook() {
        try {
            System.out.print("Enter Book ID: ");
            int bookId = sc.nextInt();

            if (!books.containsKey(bookId)) {
                System.out.println("Book not found.");
                return;
            }

            Book book = books.get(bookId);

            if (book.isIssued()) {
                System.out.println("Book already issued.");
                return;
            }

            System.out.print("Enter Member ID: ");
            int memberId = sc.nextInt();

            if (!members.containsKey(memberId)) {
                System.out.println("Member not found.");
                return;
            }

            Member m = members.get(memberId);
            book.markAsIssued();
            m.addIssuedBook(bookId);

            saveToFile();
            System.out.println("Book issued successfully!");

        } catch (Exception e) {
            System.out.println("Error issuing book.");
        }
    }

    // Return Book
    public void returnBook() {
        try {
            System.out.print("Enter Book ID: ");
            int bookId = sc.nextInt();

            if (!books.containsKey(bookId)) {
                System.out.println("Book not found.");
                return;
            }

            Book book = books.get(bookId);

            if (!book.isIssued()) {
                System.out.println("Book is not issued.");
                return;
            }

            System.out.print("Enter Member ID: ");
            int memberId = sc.nextInt();

            Member m = members.get(memberId);
            book.markAsReturned();
            m.returnIssuedBook(bookId);

            saveToFile();
            System.out.println("Book returned successfully!");

        } catch (Exception e) {
            System.out.println("Error returning book.");
        }
    }

    // Search Books
    public void searchBooks() {
        sc.nextLine();
        System.out.print("Enter keyword (title/author/category): ");
        String keyword = sc.nextLine().toLowerCase();

        for (Book b : books.values()) {
            if (b.getTitle().toLowerCase().contains(keyword) ||
                b.getAuthor().toLowerCase().contains(keyword) ||
                b.getCategory().toLowerCase().contains(keyword)) {
                b.displayBookDetails();
                System.out.println("-----------------");
            }
        }
    }

    // Sort Books
    public void sortBooks() {
        List<Book> list = new ArrayList<>(books.values());
        Collections.sort(list);

        for (Book b : list) {
            b.displayBookDetails();
            System.out.println("-----------------");
        }
    }

    // Load From Files
    public void loadFromFile() {
        try {
            File f1 = new File("books.txt");
            File f2 = new File("members.txt");

            if (!f1.exists()) f1.createNewFile();
            if (!f2.exists()) f2.createNewFile();

            BufferedReader br = new BufferedReader(new FileReader(f1));
            String line;

            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                Book b = new Book(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3]);
                if (Boolean.parseBoolean(arr[4])) b.markAsIssued();
                books.put(b.getBookId(), b);
            }
            br.close();

            BufferedReader br2 = new BufferedReader(new FileReader(f2));
            while ((line = br2.readLine()) != null) {
                String[] arr = line.split(",");
                Member m = new Member(Integer.parseInt(arr[0]), arr[1], arr[2]);
                members.put(m.getMemberId(), m);
            }
            br2.close();

        } catch (Exception e) {
            System.out.println("Error loading files.");
        }
    }

    // Save to Files
    public void saveToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("books.txt"));
            for (Book b : books.values()) {
                bw.write(b.toString());
                bw.newLine();
            }
            bw.close();

            BufferedWriter bw2 = new BufferedWriter(new FileWriter("members.txt"));
            for (Member m : members.values()) {
                bw2.write(m.toString());
                bw2.newLine();
            }
            bw2.close();

        } catch (Exception e) {
            System.out.println("Error saving files.");
        }
    }

    // Main Menu
    public void menu() {
        while (true) {
            System.out.println("\n------ City Library Digital Management System ------");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Books");
            System.out.println("6. Sort Books");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addBook(); break;
                case 2: addMember(); break;
                case 3: issueBook(); break;
                case 4: returnBook(); break;
                case 5: searchBooks(); break;
                case 6: sortBooks(); break;
                case 7:
                    saveToFile();
                    System.out.println("Exiting system. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void main(String[] args) {
        LibraryManager lm = new LibraryManager();
        lm.menu();
    }
}

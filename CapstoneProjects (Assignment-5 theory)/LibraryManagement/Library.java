import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added!");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }

        System.out.println("\n--- BOOK LIST ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void searchBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book Found: " + b);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void issueBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (!b.isIssued()) {
                    b.issueBook();
                    System.out.println("Book issued!");
                } else {
                    System.out.println("Book already issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void returnBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (b.isIssued()) {
                    b.returnBook();
                    System.out.println("Book returned!");
                } else {
                    System.out.println("This book was not issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }
}

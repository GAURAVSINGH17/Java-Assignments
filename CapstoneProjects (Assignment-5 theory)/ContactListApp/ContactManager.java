import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String phone, String email) {
        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully!");
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found!");
            return;
        }

        System.out.println("\n--- CONTACT LIST ---");
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public void searchContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact Found: " + c);
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    public void deleteContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                contacts.remove(c);
                System.out.println("Contact deleted!");
                return;
            }
        }
        System.out.println("Contact not found!");
    }
}

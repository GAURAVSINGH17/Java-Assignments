// ManagementSystem.java
import java.util.Scanner;

public class ManagementSystem {
    private Employee[] employees = new Employee[200];
    private int count = 0;
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ManagementSystem ms = new ManagementSystem();
        ms.run();
    }

    public void run() {
        while (true) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Manager");
            System.out.println("2. Add Developer");
            System.out.println("3. Display Employee Details (by ID)");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int ch = -1;
            try {
                ch = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (ch) {
                case 1:
                    addManagerInteractive();
                    break;
                case 2:
                    addDeveloperInteractive();
                    break;
                case 3:
                    displayEmployeeById();
                    break;
                case 4:
                    displayAllEmployees();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Overloaded method: add manager by direct parameters
    public void addManager(int id, String name, double salary, String department) {
        Manager m = new Manager(id, name, salary, department);
        employees[count++] = m;
        System.out.println("Manager added successfully.");
    }

    // Overloaded method: add manager by interactive input
    public void addManagerInteractive() {
        try {
            System.out.print("Enter Manager ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = Double.parseDouble(sc.nextLine().trim());

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            addManager(id, name, salary, department); // reuse overloaded method
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered. Aborting add operation.");
        }
    }

    // Overloaded method: add developer by direct parameters
    public void addDeveloper(int id, String name, double salary, String language) {
        Developer d = new Developer(id, name, salary, language);
        employees[count++] = d;
        System.out.println("Developer added successfully.");
    }

    // Overloaded method: add developer interactively
    public void addDeveloperInteractive() {
        try {
            System.out.print("Enter Developer ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = Double.parseDouble(sc.nextLine().trim());

            System.out.print("Enter Programming Language: ");
            String language = sc.nextLine();

            addDeveloper(id, name, salary, language); // reuse overloaded method
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered. Aborting add operation.");
        }
    }

    // Display one employee by ID
    public void displayEmployeeById() {
        System.out.print("Enter Employee ID to search: ");
        try {
            int id = Integer.parseInt(sc.nextLine().trim());
            Employee e = findEmployee(id);
            if (e != null) {
                e.displayDetails(); // polymorphic call
            } else {
                System.out.println("Employee with ID " + id + " not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID entered.");
        }
    }

    // Display all employees
    public void displayAllEmployees() {
        if (count == 0) {
            System.out.println("No employees available.");
            return;
        }
        System.out.println("\nAll Employees:");
        for (int i = 0; i < count; i++) {
            employees[i].displayDetails(); // polymorphism in action
        }
    }

    // Helper to find employee by id
    private Employee findEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == id) return employees[i];
        }
        return null;
    }
}

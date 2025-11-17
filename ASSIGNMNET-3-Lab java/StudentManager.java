import java.util.*;

/*
  StudentManager implements RecordActions.
  Demonstrates:
  - try/catch/finally for validation and resource cleanup
  - throwing custom StudentNotFoundException
  - multithreading via Loader when adding/saving a student
  - wrapper classes Integer and Double for autoboxing
*/

public class StudentManager implements RecordActions {
    private Map<Integer, Student> students = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    // Add student: validates input and uses a Loader thread to simulate saving
    @Override
    public void addStudent() {
        try {
            System.out.print("Enter Roll No (Integer): ");
            String rollInput = scanner.nextLine().trim();
            if (rollInput.isEmpty()) throw new IllegalArgumentException("Roll number cannot be empty.");

            // wrapper Integer: parseInt returns primitive int, autoboxing to Integer
            Integer roll = Integer.parseInt(rollInput);

            if (students.containsKey(roll)) {
                System.out.println("Student with roll " + roll + " already exists.");
                return;
            }

            System.out.print("Enter Name: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");

            System.out.print("Enter Email: ");
            String email = scanner.nextLine().trim();
            if (email.isEmpty() || !email.contains("@") || !email.contains(".")) {
                throw new IllegalArgumentException("Invalid email format.");
            }

            System.out.print("Enter Course: ");
            String course = scanner.nextLine().trim();
            if (course.isEmpty()) throw new IllegalArgumentException("Course cannot be empty.");

            System.out.print("Enter Marks (Double): ");
            String marksInput = scanner.nextLine().trim();
            if (marksInput.isEmpty()) throw new IllegalArgumentException("Marks cannot be empty.");

            // wrapper Double: parseDouble returns primitive double, autoboxing to Double
            Double marks = Double.parseDouble(marksInput);

            // validate marks range 0 - 100
            if (marks < 0 || marks > 100) {
                throw new IllegalArgumentException("Marks must be between 0 and 100.");
            }

            // simulate loading using a separate thread
            Thread loaderThread = new Thread(new Loader(1000)); // 1 second total
            loaderThread.start();

            // simulate some processing time on main thread too
            try {
                loaderThread.join(); // wait for loader to finish (simulate synchronous save)
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }

            Student s = new Student(roll, name, email, course, marks);
            students.put(roll, s);
            System.out.println("Student added successfully.");

        } catch (NumberFormatException nfe) {
            System.out.println("Input error: Roll and Marks must be numeric. " + nfe.getMessage());
        } catch (IllegalArgumentException iae) {
            System.out.println("Validation error: " + iae.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            // nothing to close here (scanner closed in main), but demonstrating finally usage
            System.out.println("Returning to main menu...");
        }
    }

    // Show student details by roll number, throws StudentNotFoundException if not present
    @Override
    public void showStudent() throws StudentNotFoundException {
        try {
            System.out.print("Enter Roll No to search: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) throw new IllegalArgumentException("Roll number cannot be empty.");

            Integer roll = Integer.parseInt(input);
            if (!students.containsKey(roll)) {
                throw new StudentNotFoundException("Student with roll " + roll + " not found.");
            }

            // Loading simulation when displaying
            Thread loader = new Thread(new Loader(600));
            loader.start();
            loader.join();

            Student s = students.get(roll);
            s.display();
            System.out.println("Program execution completed.");

        } catch (NumberFormatException nfe) {
            System.out.println("Input error: Roll must be an integer.");
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            System.out.println("Loading interrupted.");
        } finally {
            System.out.println("Search operation finished (finally).");
        }
    }

    // A small saveAll to demonstrate a threaded save (not writing files, only simulate)
    @Override
    public void saveAll() {
        System.out.println("Saving all student data...");
        Thread loader = new Thread(new Loader(800));
        loader.start();
        try {
            loader.join();
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        System.out.println("All data saved (simulation).");
    }

    // main menu
    public void menu() {
        boolean exit = false;
        try {
            while (!exit) {
                System.out.println("\n--- Student Manager ---");
                System.out.println("1. Add Student");
                System.out.println("2. Show Student Details");
                System.out.println("3. Save All (simulate)");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                String choice = scanner.nextLine().trim();
                switch (choice) {
                    case "1":
                        addStudent();
                        break;
                    case "2":
                        try {
                            showStudent();
                        } catch (StudentNotFoundException snfe) {
                            System.out.println("Error: " + snfe.getMessage());
                        }
                        break;
                    case "3":
                        saveAll();
                        break;
                    case "4":
                        System.out.println("Exiting program. Goodbye!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } finally {
            // ensure scanner closed and program resources cleaned up
            scanner.close();
            System.out.println("Scanner closed. Program terminated.");
        }
    }

    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        sm.menu();
    }
}

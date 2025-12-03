// ResultManager.java
import java.util.Scanner;

public class ResultManager {
    private Student[] students = new Student[100];
    private int count = 0;

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ResultManager rm = new ResultManager();
        rm.mainMenu();
    }

    public void mainMenu() {
        while (true) {
            System.out.println("\n===== Student Result Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show Student Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showStudentDetails();
                    break;
                case 3:
                    System.out.println("Closing application...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add student with marks validation
    public void addStudent() {
        try {
            System.out.print("Enter Roll Number: ");
            int roll = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            int[] marks = new int[3];
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                marks[i] = Integer.parseInt(sc.nextLine());
            }

            Student s = new Student(roll, name, marks);
            s.validateMarks(); // may throw InvalidMarksException

            students[count++] = s;
            System.out.println("Student added successfully!");

        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Returning to main menu...");
        } catch (NumberFormatException e) {
            System.out.println("Input mismatch! Please enter numbers only.");
        } catch (NullPointerException e) {
            System.out.println("Null value found! Please enter valid details.");
        } catch (Exception e) {
            System.out.println("An error occurred. " + e.getMessage());
        } finally {
            System.out.println("Operation complete.\n");
        }
    }

    // Show details of a specific student
    public void showStudentDetails() {
        try {
            System.out.print("Enter Roll Number to search: ");
            int roll = Integer.parseInt(sc.nextLine());

            Student s = findStudent(roll);

            if (s != null) {
                s.displayResult();
            } else {
                System.out.println("Student not found!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid roll number entered!");
        } finally {
            System.out.println("Returning to menu...");
        }
    }

    // helper method
    private Student findStudent(int roll) {
        for (int i = 0; i < count; i++) {
            if (students[i] != null && students[i].rollNumber == roll) {
                return students[i];
            }
        }
        return null;
    }
}

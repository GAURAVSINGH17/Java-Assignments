// ResultManager.java
// Manages multiple Student objects, input, and exception handling.
// Demonstrates try-catch, throw/throws, and finally.

import java.util.InputMismatchException;
import java.util.Scanner;

public class ResultManager {
    private Student[] students;
    private int count;
    private Scanner scanner;

    public ResultManager(int capacity) {
        students = new Student[capacity];
        count = 0;
        scanner = new Scanner(System.in);
    }

    // Add a student - declares that it throws InvalidMarksException (checked)
    public void addStudent() throws InvalidMarksException {
        System.out.print("Enter Roll Number: ");
        int roll = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        // Create student (constructor will validate marks and may throw InvalidMarksException)
        Student s = new Student(roll, name, marks);
        if (count >= students.length) {
            System.out.println("Storage full. Cannot add more students.");
            return;
        }
        students[count++] = s;
        System.out.println("Student added successfully. Returning to main menu...");
    }

    // Show details of a student. Handle not found or invalid inputs.
    public void showStudentDetails() {
        System.out.print("Enter Roll Number to search: ");
        try {
            int roll = scanner.nextInt();
            Student found = null;
            for (int i = 0; i < count; i++) {
                if (students[i] != null && students[i].getRollNumber() == roll) {
                    found = students[i];
                    break;
                }
            }
            if (found != null) {
                found.displayResult();
                System.out.println("Search completed.");
            } else {
                System.out.println("Student with roll number " + roll + " not found.");
            }
        } catch (InputMismatchException ime) {
            System.out.println("Input error: please enter a valid integer roll number.");
            scanner.nextLine(); // clear invalid input
        } catch (Exception e) {
            System.out.println("Unexpected error while searching: " + e.getMessage());
        }
    }

    // main menu loop demonstrating try-catch-finally usage
    public void mainMenu() {
        boolean exit = false;
        try {
            while (!exit) {
                System.out.println();
                System.out.println("===== Student Result Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. Show Student Details");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice;
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException ime) {
                    System.out.println("Invalid choice. Please enter numeric choice 1-3.");
                    scanner.nextLine(); // clear invalid input
                    continue;
                }

                switch (choice) {
                    case 1:
                        try {
                            addStudent(); // may throw InvalidMarksException
                        } catch (InvalidMarksException ime) {
                            // Handle custom checked exception
                            System.out.println("Error: " + ime.getMessage() + " Returning to main menu...");
                        } catch (InputMismatchException inme) {
                            System.out.println("Invalid input while adding student. Returning to main menu...");
                            scanner.nextLine(); // clear invalid input
                        } catch (Exception e) {
                            System.out.println("Unexpected error while adding student: " + e.getMessage());
                        }
                        break;
                    case 2:
                        showStudentDetails();
                        break;
                    case 3:
                        System.out.println("Exiting program. Thank you!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Please choose a valid option (1-3).");
                }
            }
        } finally {
            // finally clause ensures scanner is closed and displayed message executed
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("Application closed. Scanner released.");
        }
    }

    public static void main(String[] args) {
        // Capacity set to 100 students (can modify)
        ResultManager manager = new ResultManager(100);
        manager.mainMenu();
    }
}

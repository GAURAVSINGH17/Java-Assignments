package app;

import model.Student;
import service.StudentManager;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("===== Capstone Student Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete by Name");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Save and Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Roll No: ");
                        int roll = sc.nextInt(); sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();

                        Student s = new Student(roll, name, email, course, marks);
                        manager.addStudent(s);
                        break;

                    case 2:
                        manager.viewAllStudents();
                        break;

                    case 3:
                        System.out.print("Enter name to search: ");
                        Student found = manager.searchStudent(sc.nextLine());
                        found.displayInfo();
                        break;

                    case 4:
                        System.out.print("Enter name to delete: ");
                        manager.deleteStudent(sc.nextLine());
                        System.out.println("Student Deleted.");
                        break;

                    case 5:
                        manager.sortByMarks();
                        manager.viewAllStudents();
                        break;

                    case 6:
                        manager.saveToFile();
                        System.out.println("Saved and exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

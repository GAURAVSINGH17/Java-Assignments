import java.util.*;
import java.io.*;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        String filename = "students.txt";

        manager.loadStudents(filename);

        while (true) {
            System.out.println("\n===== Capstone Student Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete by Name");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Save and Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    Integer roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    Double marks = sc.nextDouble();

                    manager.addStudent(new Student(roll, name, email, course, marks));
                    break;

                case 2:
                    manager.viewAll();
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String n = sc.nextLine();
                    Student s = manager.searchByName(n);
                    if (s != null) System.out.println(s);
                    else System.out.println("Student not found!");
                    break;

                case 4:
                    System.out.print("Enter name to delete: ");
                    String d = sc.nextLine();
                    if (manager.deleteByName(d)) System.out.println("Deleted!");
                    else System.out.println("Not found!");
                    break;

                case 5:
                    manager.sortByMarks();
                    break;

                case 6:
                    manager.save(filename);
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}

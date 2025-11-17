import java.util.Scanner;

public class StudentManagement {

    private Student[] students = new Student[100];
    private int studentCount = 0;

    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        if (studentCount >= students.length) {
            System.out.println("Student limit reached!");
            return;
        }

        Student s = new Student();
        s.inputDetails(sc);
        students[studentCount] = s;
        studentCount++;

        System.out.println("Student Added Successfully!");
    }

    public void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No student records found.");
            return;
        }

        for (int i = 0; i < studentCount; i++) {
            System.out.println("-----------------------------");
            students[i].displayDetails();
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n===== Student Record Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayAllStudents(); break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        sm.menu();
    }
}

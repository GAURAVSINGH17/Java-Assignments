package App;

import Model.Student;
import Service.StudentManager;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        Student s1 = new Student(101, "Ankit", "ankit@mail.com", "B.Tech", 85.5, "A");
        Student s2 = new Student(102, "Riya", "riya@mail.com", "M.Tech", 90.0, "A+");

        // Add Students
        manager.addStudent(s1);
        manager.addStudent(s2);

        // View All Students
        manager.viewAllStudents();

        // Overloaded method
        s1.displayInfo("AI");

        // Update student
        Student updatedS1 = new Student(101, "Ankit", "ankit@mail.com", "B.Tech", 88.0, "A+");
        manager.updateStudent(101, updatedS1);

        // Search Student
        Student found = manager.searchStudent(101);
        if (found != null) {
            found.displayInfo();
        }

        // Delete Student
        manager.deleteStudent(102);

        // View All Students
        manager.viewAllStudents();
    }
}

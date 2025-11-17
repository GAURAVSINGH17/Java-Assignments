// File: service/StudentManager.java
package Service;

import Model.Student;
import java.util.HashMap;
import java.util.Map;

public class StudentManager implements RecordActions {
    private Map<Integer, Student> students = new HashMap<>();

    @Override
    public void addStudent(Student student) {
        if (students.containsKey(student.getRollNo())) {
            System.out.println("Student with roll no " + student.getRollNo() + " already exists.");
        } else {
            students.put(student.getRollNo(), student);
            System.out.println("Student added successfully.");
        }
    }

    @Override
    public void deleteStudent(int rollNo) {
        if (students.containsKey(rollNo)) {
            students.remove(rollNo);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    @Override
    public void updateStudent(int rollNo, Student student) {
        if (students.containsKey(rollNo)) {
            students.put(rollNo, student);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    @Override
    public Student searchStudent(int rollNo) {
        return students.getOrDefault(rollNo, null);
    }

    @Override
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student s : students.values()) {
                s.displayInfo();
            }
        }
    }
}

// File: service/RecordActions.java
package Service;

import Model.Student;

public interface RecordActions {
    void addStudent(Student student);
    void deleteStudent(int rollNo);
    void updateStudent(int rollNo, Student student);
    Student searchStudent(int rollNo);
    void viewAllStudents();
}

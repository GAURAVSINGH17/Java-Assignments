import java.util.*;
import java.io.*;

@SuppressWarnings("unused")
public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    // Load students from file
    public void loadStudents(String filename) {
        try {
            students = FileUtil.readStudents(filename);
            System.out.println("Loaded students from file:");
            for (Student s : students) {
                System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
    }

    // Add student
    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully!");
    }

    // View all
    public void viewAll() {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // Search by name
    public Student searchByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    // Delete by name
    public boolean deleteByName(String name) {
        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            Student s = it.next();
            if (s.getName().equalsIgnoreCase(name)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    // Sort by marks
    public void sortByMarks() {
        students.sort((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()));
        System.out.println("Students sorted by marks:");
        for (Student s : students) System.out.println(s);
    }

    // Save to file
    public void save(String filename) {
        try {
            FileUtil.writeStudents(filename, students);
            System.out.println("Records saved successfully!");
        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}

package service;

import model.Student;
import util.StudentNotFoundException;
import util.Loader;

import java.io.*;
import java.util.*;

public class StudentManager implements RecordActions {

    private List<Student> students = new ArrayList<>();
    private final String FILE = "students.txt";

    public StudentManager() {
        loadFromFile();
    }

    @Override
    public void addStudent(Student s) {
        students.add(s);
        showLoader();
    }

    @Override
    public void deleteStudent(String name) throws Exception {
        Student s = searchStudent(name);
        students.remove(s);
        showLoader();
    }

    @Override
    public Student searchStudent(String name) throws Exception {
        return students.stream()
            .filter(s -> s.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
    }

    @Override
    public void updateStudent(int rollNo, Student updated) throws Exception {}

    @Override
    public void viewAllStudents() {
        for (Student s : students) {
            s.displayInfo();
            System.out.println("----------------");
        }
    }

    public void sortByMarks() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
    }

    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            for (Student s : students) {
                bw.write(s.getRollNo() + "," + s.getName() + "," + s.getEmail() + 
                         "," + s.getCourse() + "," + s.getMarks());
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                Student s = new Student(
                    Integer.parseInt(d[0]),
                    d[1],
                    d[2],
                    d[3],
                    Double.parseDouble(d[4])
                );
                students.add(s);
            }
        } catch (Exception ignored) {}
    }

    private void showLoader() {
        Thread t = new Thread(new Loader());
        t.start();
        try { t.join(); } catch (Exception e) {}
    }
}

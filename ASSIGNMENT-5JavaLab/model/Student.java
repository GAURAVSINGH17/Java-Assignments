package model;

public class Student extends Person {

    private int rollNo;
    private String course;
    private double marks;
    private String grade;

    // Constructor
    public Student(int rollNo, String name, String email, String course, double marks) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    // Calculate grade
    public void calculateGrade() {
        if (marks >= 90) grade = "A";
        else if (marks >= 80) grade = "B";
        else if (marks >= 70) grade = "C";
        else if (marks >= 60) grade = "D";
        else grade = "F";
    }

    @Override
    public void displayInfo() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }

    // ✔ GETTERS (NO MORE ERRORS)
    public int getRollNo() {
        return rollNo;
    }

    public String getCourse() {
        return course;       // FIXED
    }

    public double getMarks() {
        return marks;        // FIXED
    }

    public String getGrade() {
        return grade;
    }

    // ✔ SETTERS if needed
    public void setMarks(double marks) {
        this.marks = marks;
        calculateGrade();
    }
}

import java.util.Objects;

public class Student {
    // Wrapper classes used (Integer, Double) demonstrating autoboxing
    private Integer rollNo;
    private String name;
    private String email;
    private String course;
    private Double marks; // decimal marks allowed
    private String grade;

    public Student(Integer rollNo, String name, String email, String course, Double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
        this.grade = calculateGrade();
    }

    // Basic grade calculation
    private String calculateGrade() {
        if (marks == null) return "N/A";
        double m = marks;
        if (m >= 85) return "A+";
        if (m >= 75) return "A";
        if (m >= 65) return "B";
        if (m >= 50) return "C";
        return "D";
    }

    public Integer getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public Double getMarks() { return marks; }
    public String getGrade() { return grade; }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }

    @Override
    public String toString() {
        return rollNo + "," + name + "," + email + "," + course + "," + marks + "," + grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return Objects.equals(rollNo, s.rollNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }
}

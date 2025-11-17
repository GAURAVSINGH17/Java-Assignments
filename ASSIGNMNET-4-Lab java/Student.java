public class Student implements Comparable<Student> {
    private Integer rollNo;
    private String name;
    private String email;
    private String course;
    private Double marks;

    public Student(Integer rollNo, String name, String email, String course, Double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public Double getMarks() {
        return marks;
    }

    @Override
    public int compareTo(Student s) {
        return this.name.compareToIgnoreCase(s.name);
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo +
               "\nName: " + name +
               "\nEmail: " + email +
               "\nCourse: " + course +
               "\nMarks: " + marks + "\n";
    }
}

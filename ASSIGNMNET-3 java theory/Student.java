// Student.java
// Represents a student with roll number, name and marks for 3 subjects.
// Contains validation logic and methods to calculate average and display result.

public class Student {
    private int rollNumber;
    private String studentName;
    private int[] marks; // length 3

    public Student(int rollNumber, String studentName, int[] marks) throws InvalidMarksException {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        if (marks == null || marks.length != 3) {
            throw new IllegalArgumentException("Marks array must contain exactly 3 subject marks.");
        }
        this.marks = marks.clone();
        validateMarks(); // may throw InvalidMarksException
    }

    // Validates marks are between 0 and 100 inclusive. Throws custom checked exception.
    public void validateMarks() throws InvalidMarksException {
        for (int i = 0; i < marks.length; i++) {
            int m = marks[i];
            if (m < 0 || m > 100) {
                throw new InvalidMarksException("Invalid marks for subject " + (i + 1) + ": " + m
                        + ". Marks should be between 0 and 100.");
            }
        }
    }

    // Calculate average (double)
    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum / 3.0;
    }

    // Return "Pass" if all marks >= 35 (or change passing criteria here), else "Fail"
    public String getResultStatus() {
        for (int m : marks) {
            if (m < 35) return "Fail";
        }
        return "Pass";
    }

    // Display student details
    public void displayResult() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Student Name: " + studentName);
        System.out.print("Marks: ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + (i == marks.length - 1 ? "" : " "));
        }
        System.out.println();
        System.out.println("Average: " + calculateAverage());
        System.out.println("Result: " + getResultStatus());
    }

    public int getRollNumber() {
        return rollNumber;
    }
}

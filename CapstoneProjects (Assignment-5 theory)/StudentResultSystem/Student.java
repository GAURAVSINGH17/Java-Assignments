// Student.java
public class Student {
    int rollNumber;
    private String studentName;
    private int[] marks = new int[3];

    public Student(int rollNumber, String studentName, int[] marks) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.marks = marks;
    }

    // Validate marks - throws custom exception
    public void validateMarks() throws InvalidMarksException {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarksException(
                    "Invalid marks for subject " + (i + 1) + ": " + marks[i]
                );
            }
        }
    }

    // calculate average
    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum / 3.0;
    }

    // display result
    public void displayResult() {
        System.out.println("\n--- Student Result ---");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + studentName);
        System.out.println("Marks: ");
        for (int i = 0; i < marks.length; i++)
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);

        double avg = calculateAverage();
        System.out.println("Average: " + avg);

        if (avg >= 40) System.out.println("Result: PASS");
        else System.out.println("Result: FAIL");
    }
}

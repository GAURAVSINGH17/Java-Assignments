// Developer.java
public class Developer extends Employee {
    private String programmingLanguage;

    public Developer() {
        super();
    }

    public Developer(int employeeId, String name, double salary, String programmingLanguage) {
        super(employeeId, name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    // Override to provide different bonus structure for developers
    @Override
    public double calculateBonus() {
        // developer bonus - 12% of salary
        return salary * 0.12;
    }

    @Override
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId +
                           ", Name: " + name +
                           ", Role: Developer" +
                           ", Language: " + programmingLanguage +
                           ", Salary: " + salary +
                           ", Bonus: " + String.format("%.2f", calculateBonus()));
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
}

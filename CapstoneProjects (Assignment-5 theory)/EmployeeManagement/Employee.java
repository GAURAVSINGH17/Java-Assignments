// Employee.java
public class Employee {
    protected int employeeId;
    protected String name;
    protected double salary;

    public Employee() {
    }

    public Employee(int employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    // Method to calculate bonus (base implementation)
    public double calculateBonus() {
        // base bonus - 10% of salary
        return salary * 0.10;
    }

    // Display details (can be overridden or extended)
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId +
                           ", Name: " + name +
                           ", Salary: " + salary +
                           ", Bonus: " + String.format("%.2f", calculateBonus()));
    }

    // Overloaded helper methods (example of method overloading)
    public void setDetails(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public void setDetails(int employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    // getters
    public int getEmployeeId() {
        return employeeId;
    }
}

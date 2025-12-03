// Manager.java
public class Manager extends Employee {
    private String department;

    public Manager() {
        super();
    }

    public Manager(int employeeId, String name, double salary, String department) {
        super(employeeId, name, salary);
        this.department = department;
    }

    // Override to provide higher bonus for managers
    @Override
    public double calculateBonus() {
        // manager bonus - 15% of salary
        return salary * 0.15;
    }

    @Override
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId +
                           ", Name: " + name +
                           ", Role: Manager" +
                           ", Department: " + department +
                           ", Salary: " + salary +
                           ", Bonus: " + String.format("%.2f", calculateBonus()));
    }

    public String getDepartment() {
        return department;
    }
}

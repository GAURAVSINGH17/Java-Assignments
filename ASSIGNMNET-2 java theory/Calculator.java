// Calculator.java
public class Calculator {

    // Overloaded add methods
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Subtract method
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiply method (double parameters)
    public double multiply(double a, double b) {
        return a * b;
    }

    // Divide method with exception handling
    public double divide(int a, int b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero!");
            }
            return (double) a / b;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
}

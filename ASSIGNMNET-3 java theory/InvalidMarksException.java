// InvalidMarksException.java
// Custom checked exception used when marks are outside 0-100 range.

public class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

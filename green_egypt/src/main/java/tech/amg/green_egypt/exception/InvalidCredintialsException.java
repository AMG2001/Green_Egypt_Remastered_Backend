package tech.amg.green_egypt.exception;

public class InvalidCredintialsException extends RuntimeException {

    public InvalidCredintialsException() {
        super("Invalid credentials");
    }
}

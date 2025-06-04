package tech.amg.green_egypt.exception;

public class EmailAlreadyExistException extends RuntimeException {

    public EmailAlreadyExistException() {
        super("Email already registered");
    }
}

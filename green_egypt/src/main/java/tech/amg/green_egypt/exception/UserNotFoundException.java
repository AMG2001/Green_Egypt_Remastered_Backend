package tech.amg.green_egypt.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User not found");
    }
}

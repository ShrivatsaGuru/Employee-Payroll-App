package validation;


public class DuplicateUserException extends ValidationException {
    public DuplicateUserException() { super("Username is already taken."); }
}
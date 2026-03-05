package validation;

public class InvalidUsernameException extends ValidationException {
    public InvalidUsernameException() { super("Username must start with a letter and be 3–16 chars (letters/digits/_)."); }
}
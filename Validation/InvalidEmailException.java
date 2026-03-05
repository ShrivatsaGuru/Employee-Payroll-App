package validation;

public class InvalidEmailException extends ValidationException {
    public InvalidEmailException() { super("Email format is invalid."); }
}

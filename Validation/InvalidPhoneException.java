package validation;

public class InvalidPhoneException extends ValidationException {
    public InvalidPhoneException() { super("Phone must be exactly 10 digits."); }
}
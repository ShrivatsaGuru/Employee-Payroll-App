package validation;

/** Used by login flow to communicate friendly auth failures (UC6). */
public class AuthFailedException extends ValidationException {
    public AuthFailedException(String message) { super(message); }
}

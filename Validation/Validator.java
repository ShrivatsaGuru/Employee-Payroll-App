package validation;


public final class Validator {
    private Validator() {}

    // --- Simple, readable patterns (UC6) ---
    private static final String USER_RE = "^[A-Za-z][A-Za-z0-9_]{2,15}$";
    private static final String EMAIL_RE = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PHONE_RE = "^\\d{10}$";
    private static final String PASS_RE  = "^(?=.*[A-Za-z])(?=.*\\d).{6,}$";

    // --- Sanitizers (trim, normalize) ---
    public static String cleanUsername(String s) { return s == null ? "" : s.trim(); }
    public static String cleanEmail(String s)    { return s == null ? "" : s.trim().toLowerCase(); }
    public static String cleanPhone(String s)    { return s == null ? "" : s.replaceAll("\\s+", ""); }

    // --- Fail-fast validators (throw custom exceptions) ---
    public static void checkUsername(String s) throws InvalidUsernameException {
        if (!s.matches(USER_RE)) throw new InvalidUsernameException();
    }
    public static void checkEmail(String s) throws InvalidEmailException {
        if (!s.matches(EMAIL_RE)) throw new InvalidEmailException();
    }
    public static void checkPhone(String s) throws InvalidPhoneException {
        if (!s.matches(PHONE_RE)) throw new InvalidPhoneException();
    }

}
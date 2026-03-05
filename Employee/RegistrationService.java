package employee;

import validation.*;
import user.*;

import java.util.HashMap;
import java.util.Map;

public class RegistrationService {
    private final Map<String, User> users = new HashMap<>();

    // Simple RegEx validations (core Java)
    private static final String EMAIL_RE  = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PHONE_RE  = "^\\d{10}$";
    private static final String USER_RE   = "^[A-Za-z][A-Za-z0-9_]{2,15}$";

    public boolean register(String username, String email, String phone, String role, String rawPassword) {
        if (username == null || email == null || phone == null || role == null || rawPassword == null) return false;
        if (!username.matches(USER_RE) || !email.matches(EMAIL_RE) || !phone.matches(PHONE_RE)) return false;
        if (users.containsKey(username)) return false;

        String hash = PasswordEncoder.sha256(rawPassword);
        User u = "MANAGER".equalsIgnoreCase(role)
                ? new Manager(username, email, phone, hash)
                : new RegularEmployee(username, email, phone, hash);

        users.put(username, u);
        return true;
    }

    public User find(String username) { return users.get(username); }
    public int count() { return users.size(); }
}
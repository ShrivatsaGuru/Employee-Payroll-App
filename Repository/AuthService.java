package repository;

import employee.*;
import user.*;
import repository.*;
import validation.*;
import session.Session;


import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private static final int  MAX_ATTEMPTS       = 3;
    private static final long SESSION_TIMEOUT_MS = 5 * 60 * 1000L;

    // Track failed attempts per username in a HashMap as well
    private final Map<String, Integer> attempts = new HashMap<>();

    public Session loginByName(String name, String rawPassword) {
        // Retrieve user from repository HashMap (byName)
        Employee emp = EmployeeRepository.getEmployeeByName(name);
        if (emp == null) {
            System.out.println("[Auth] Unknown user: " + name);
            return null;
        }

        int used = attempts.getOrDefault(name, 0);
        if (used >= MAX_ATTEMPTS) {
            System.out.println("[Auth] Account locked due to failed attempts.");
            return null;
        }

        String providedHash = PasswordEncoder.sha256(rawPassword);
        boolean ok = emp.authenticate(providedHash); // polymorphic; compares stored hash

        if (!ok) {
            attempts.put(name, used + 1);
            System.out.println("[Auth] Login failed (" + (used + 1) + "/" + MAX_ATTEMPTS + ")");
            return null;
        }

        attempts.remove(name); // reset on success
        System.out.println("[Auth] Login success. Role=" + emp.getRole());
        return new Session(emp.getName(), SESSION_TIMEOUT_MS);
    }
}

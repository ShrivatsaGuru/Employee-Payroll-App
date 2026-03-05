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

    private final Map<String, Integer> attempts = new HashMap<>();

    public Session loginByName(String name, String rawPassword) throws AuthFailedException {
        String uname = Validator.cleanUsername(name);
        if (uname.isEmpty()) throw new AuthFailedException("Username cannot be empty.");

        Employee emp = EmployeeRepository.getEmployeeByName(uname);
        if (emp == null) throw new AuthFailedException("User not found.");

        int used = attempts.getOrDefault(uname, 0);
        if (used >= MAX_ATTEMPTS) throw new AuthFailedException("Account locked due to failed attempts.");

        String providedHash = PasswordEncoder.sha256(rawPassword);
        boolean ok = emp.authenticate(providedHash);

        if (!ok) {
            attempts.put(uname, used + 1);
            throw new AuthFailedException("Invalid credentials (" + (used + 1) + "/" + MAX_ATTEMPTS + ").");
        }

        attempts.remove(uname);
        return new Session(emp.getName(), SESSION_TIMEOUT_MS);
    }
}

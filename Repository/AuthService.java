package repository;

import user.*;
import session.Session;
import validation.*;
import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private static final int MAX_ATTEMPTS = 3;
    private static final long SESSION_TIMEOUT_MS = 5 * 60 * 10L;

    private final Map<String, Integer> attempts = new HashMap<>();

    public Session login(User user, String rawPassword) {
        String u = user.getUsername();
        int used = attempts.getOrDefault(u, 0);
        if (used >= MAX_ATTEMPTS) {
            System.out.println("[Auth] Account locked due to failed attempts.");
            return null;
        }
        boolean ok = user.authenticate(PasswordEncoder.sha256(rawPassword));
        if (!ok) {
            attempts.put(u, used + 1);
            System.out.println("[Auth] Login failed (" + (used + 1) + "/" + MAX_ATTEMPTS + ")");
            return null;
        }
        attempts.remove(u);
        System.out.println("[Auth] Login success. Role=" + user.getRole());
        return new Session(u, SESSION_TIMEOUT_MS);
    }
}
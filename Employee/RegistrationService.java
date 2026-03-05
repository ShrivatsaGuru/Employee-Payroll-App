package employee;

import employee.*;
import user.*;
import repository.*;
import validation.*;
import session.Session;


import java.util.concurrent.atomic.AtomicInteger;

public class RegistrationService {
    private static final AtomicInteger ID_SEQ = new AtomicInteger(1000);

    // Simple validations to keep it core Java & tiny
    private static final String EMAIL_RE = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PHONE_RE = "^\\d{10}$";
    private static final String USER_RE  = "^[A-Za-z][A-Za-z0-9_]{2,15}$";

    public Employee register(String name, String email, String phone, String role, String rawPassword) {
        if (name == null || email == null || phone == null || role == null || rawPassword == null) return null;
        if (!name.matches(USER_RE) || !email.matches(EMAIL_RE) || !phone.matches(PHONE_RE)) return null;
        if (EmployeeRepository.existsByName(name)) return null; // unique username

        int id = ID_SEQ.getAndIncrement();
        String hash = PasswordEncoder.sha256(rawPassword);

        Employee e = "MANAGER".equalsIgnoreCase(role)
                ? new Manager(id, name, email, phone, hash)
                : new RegularEmployee(id, name, email, phone, hash);

        // Store in repository HashMaps (by id & by name)
        EmployeeRepository.addEmployee(e);
        return e;
    }
}
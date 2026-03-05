package employee;

import validation.*;
import repository.*;
import user.*;

import java.util.concurrent.atomic.AtomicInteger;

public class RegistrationService {
    private static final AtomicInteger ID_SEQ = new AtomicInteger(1000);

    /** UC6: Validate + sanitize + fail fast with custom exceptions. */
    public Employee register(String name, String email, String phone, String role, String rawPassword)
            throws ValidationException {

        // --- sanitize ---
        String uName  = Validator.cleanUsername(name);
        String uEmail = Validator.cleanEmail(email);
        String uPhone = Validator.cleanPhone(phone);

        // --- validate (fail-fast) ---
        Validator.checkUsername(uName);
        Validator.checkEmail(uEmail);
        Validator.checkPhone(uPhone);

        if (EmployeeRepository.existsByName(uName)) throw new DuplicateUserException();

        int id = ID_SEQ.getAndIncrement();
        String hash = PasswordEncoder.sha256(rawPassword);

        Employee e = "MANAGER".equalsIgnoreCase(role)
                ? new Manager(id, uName, uEmail, uPhone, hash)
                : new RegularEmployee(id, uName, uEmail, uPhone, hash);

        EmployeeRepository.addEmployee(e);
        return e;
    }
}
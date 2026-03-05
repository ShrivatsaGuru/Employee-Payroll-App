package user;
import employee.*;
public class RegularEmployee extends Employee {
    public RegularEmployee(int empId, String name, String email, String phone, String passwordHash) {
        super(empId, name, email, phone, passwordHash, "EMPLOYEE");
    }
    @Override public boolean authenticate(String providedHash) {
        return this.passwordHash.equals(providedHash);
    }
}
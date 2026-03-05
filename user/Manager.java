package user;
import employee.*;
public class Manager extends Employee {
    public Manager(int empId, String name, String email, String phone, String passwordHash) {
        super(empId, name, email, phone, passwordHash, "MANAGER");
    }
    @Override public boolean authenticate(String providedHash) {
        return this.passwordHash.equals(providedHash);
    }
}
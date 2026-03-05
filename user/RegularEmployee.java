package user;

public class RegularEmployee extends User {
    public RegularEmployee(String username, String email, String phone, String passwordHash) {
        super(username, email, phone, passwordHash, "EMPLOYEE");
    }
    @Override public boolean authenticate(String providedHash) {
        return this.passwordHash.equals(providedHash);
    }
}
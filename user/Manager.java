package user;

public class Manager extends User {
    public Manager(String username, String email, String phone, String passwordHash) {
        super(username, email, phone, passwordHash, "MANAGER");
    }
    @Override public boolean authenticate(String providedHash) {
        return this.passwordHash.equals(providedHash);
    }
}
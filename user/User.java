package user;

public abstract class User {
    protected final String username;
    protected final String email;
    protected final String phone;
    protected final String passwordHash; // stored hash
    protected final String role;         // "EMPLOYEE" or "MANAGER"

    protected User(String username, String email, String phone, String passwordHash, String role) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public String getUsername() { return username; }
    public String getRole() { return role; }

    // Polymorphic contract (can add role-specific checks if needed)
    public abstract boolean authenticate(String providedHash);

    @Override public String toString() {
        return role + "{" + "username='" + username + "', email='" + email + "', phone='" + phone + "'}";
    }
}
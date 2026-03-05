package employee;

public abstract class Employee {
    protected final int empId;
    protected final String name;         // username for login
    protected final String email;
    protected final String phone;
    protected final String passwordHash; // stored hash
    protected final String role;         // "EMPLOYEE" or "MANAGER"

    protected Employee(int empId, String name, String email, String phone, String passwordHash, String role) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public int getEmpId() { return empId; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public String getPasswordHash() { return passwordHash; }

    // Polymorphic: subclasses can add policy
    public abstract boolean authenticate(String providedHash);

    @Override public String toString() {
        return role + "{id=" + empId + ", name='" + name + "', email='" + email + "', phone='" + phone + "'}";
    }
}
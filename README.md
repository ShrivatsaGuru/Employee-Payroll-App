# EmployeePayrollApp
Develop an Employee Payroll Management System that serves as a hands-on laboratory for mastering Object-Oriented Programming (OOP) concepts through real-world enterprise application development. The application demonstrates how core OOP principles solve complex business problems while maintaining code quality, scalability, and maintainability.

## UC2 — Employee Authentication & Login

+ Enables secure login for registered employees and managers.
+ Implements an abstract User class with authenticate() method for polymorphism.
+ Uses RegularEmployee and Manager subclasses for role-based access.
+ Verifies passwords securely using SHA-256 hashing (centralized in PasswordUtil).
+ Tracks login attempts and enforces maximum attempt limits.
+ Throws AuthenticationException for failed logins.
+ Creates and manages user sessions with SessionManager (including timeout).
+ Provides role-based dashboard messages after successful login.
+ Fully compatible with UC1 registration — no logic is broken.
+ Extensible architecture for additional user roles or multi-session handling.

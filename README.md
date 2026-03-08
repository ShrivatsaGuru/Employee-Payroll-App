# EmployeePayrollApp
Develop an Employee Payroll Management System that serves as a hands-on laboratory for mastering Object-Oriented Programming (OOP) concepts through real-world enterprise application development. The application demonstrates how core OOP principles solve complex business problems while maintaining code quality, scalability, and maintainability.

## UC1 — Employee Registration

+ Allows registering a new employee into the payroll system.
+ Collects name, email, phone, salary, department, username, and password.
+ Validates email and phone formats using regular expressions.
+ Generates a unique employee ID automatically.
+ Encrypts passwords with SHA-256 before storing.
+ Stores employee and account details in memory (EmployeeRepository).
+ Encapsulates employee information using Employee and UserAccount classes.
+ Provides readable output of employee details after registration.
+ Demonstrates OOP concepts: encapsulation, composition, service layer pattern.
+ Safe, modular, and extensible for future enhancements.

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

## UC3 — Payslip Generation

+ Allows authenticated employees to generate monthly payslips.
+ Accepts the month and year as input for the payslip.
+ Calculates gross salary components: basic, HRA, and allowances.
+ Applies statutory deductions: PF (Provident Fund) and Tax.
+ Computes the net payable amount dynamically.
+ Aggregates employee information and salary components into a Payslip object.
+ Provides a professional, formatted output using toString().
+ Supports multiple salary structures and months for historical tracking.
+ Demonstrates composition (Payslip HAS-A SalaryComponents) and aggregation (Payslip HAS-A Employee).
+ Fully compatible with UC1 registration and UC2 authentication — safe and modular.

## UC4 — Payslip Print / Download

+ Allows authenticated employees to download or print their payslip.
+ Creates a deep copy of the payslip to preserve original data integrity.
+ Generates unique filenames using employee ID, month/year, and timestamp.
+ Saves payslips as text files in a dedicated Payslips/ directory.
+ Supports potential expansion for PDF or other formats.
+ Implements clone() and equals()/hashCode() for safe object duplication.
+ Ensures no modification occurs to the original payslip object.
+ Provides professional and version-controlled file naming.
+ Demonstrates object comparison, immutability, and file I/O.
+ Fully compatible with UC1–UC3; preserves all previous functionality.

## UC5 — Dashboard Display

+ Displays a personalized payroll dashboard for authenticated employees.
+ Shows the top 3 recent payslips for quick access.
+ Calculates Year-to-Date (YTD) earnings from historical payslips.
+ Implements a Dashboard interface for pluggable, extensible dashboards.
+ Uses Stream API and Comparator for efficient data processing.
+ Supports runtime type checking for different employee roles (Regular/Manager).
+ Enables real-time data refresh each time dashboard is viewed.
+ Fully compatible with UC1–UC4; no prior functionality is affected.
+ Provides a consistent interface contract for future analytics extensions.
+ Enhances user experience with responsive and informative payroll metrics.

## UC6 — Input Validation

+ Centralizes all user input validation for the payroll system.
+ Validates email formats using regular expressions.
+ Validates phone numbers to ensure correct digit count
+ Enforces password strength rules (uppercase, lowercase, digit, special character, min 8 chars).
+ Validates employee ID patterns (e.g., EMP1001).
+ Throws ValidationException for invalid inputs with user-friendly messages.
+ Ensures fail-fast validation to prevent processing of bad data.
+ Improves security through input sanitization.
+ Provides reusable validation utilities for UC1–UC5.
+ Enhances system robustness and consistency across all user interactions.

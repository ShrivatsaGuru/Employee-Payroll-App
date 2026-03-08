# EmployeePayrollApp
Develop an Employee Payroll Management System that serves as a hands-on laboratory for mastering Object-Oriented Programming (OOP) concepts through real-world enterprise application development. The application demonstrates how core OOP principles solve complex business problems while maintaining code quality, scalability, and maintainability.

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

# EmployeePayrollApp
Develop an Employee Payroll Management System that serves as a hands-on laboratory for mastering Object-Oriented Programming (OOP) concepts through real-world enterprise application development. The application demonstrates how core OOP principles solve complex business problems while maintaining code quality, scalability, and maintainability.

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

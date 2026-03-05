package payroll;

import employee.Employee;
import payroll.Payslip;
import payroll.SalaryComponents;

/**
 * UC3: PayrollService
 * - Single responsibility: generate a Payslip from Employee + SalaryComponents.
 */
public class PayrollService {

    public Payslip generatePayslip(Employee emp, SalaryComponents sc) {
        // In a larger app, you could persist history here.
        return new Payslip(emp, sc);
    }
}
package payroll;

import employee.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 * UC5: Stores payslip history so dashboard can show top-3, YTD, etc.
 */
public class PayrollService {

    private final List<Payslip> history = new ArrayList<>();

    public Payslip generatePayslip(Employee emp, SalaryComponents sc) {
        Payslip p = new Payslip(emp, sc);
        history.add(p);  // store for UC5
        return p;
    }

    public List<Payslip> getAll() {
        return history;
    }
}
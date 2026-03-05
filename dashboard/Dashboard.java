package dashboard;

import employee.Employee;
import java.util.List;
import payroll.Payslip;

/**
 * UC5: Dashboard interface
 * - Different implementations for Employee vs Manager dashboards.
 */
public interface Dashboard {
    void show(Employee emp, List<Payslip> payslips);
}
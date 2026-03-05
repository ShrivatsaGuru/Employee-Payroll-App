package dashboard;

import employee.Employee;
import payroll.*;

import java.util.List;

/**
 * UC5: Manager Dashboard
 * - For now simple: show number of payslips + YTD.
 * - Demonstrates runtime dashboard selection via getClass().
 */
public class ManagerDashboard implements Dashboard {

    @Override
    public void show(Employee emp, List<Payslip> payslips) {
        System.out.println("\n=== Manager Dashboard ===");
        System.out.println("Hello Manager " + emp.getName());

        System.out.println("Total Payslips Generated: " + payslips.size());

        double ytd = payslips.stream().mapToDouble(Payslip::net).sum();
        System.out.println("Team YTD Earnings: " + ytd);
    }
}
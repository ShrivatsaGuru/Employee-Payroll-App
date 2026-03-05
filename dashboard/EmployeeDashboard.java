package dashboard;

import employee.Employee;
import payroll.*;
import java.util.Comparator;
import java.util.List;

/**
 * UC5: Employee Dashboard
 * - Shows last 3 payslips
 * - Shows total YTD earnings (simple sum of net values)
 */
public class EmployeeDashboard implements Dashboard {

    @Override
    public void show(Employee emp, List<Payslip> payslips) {
        System.out.println("\n=== Employee Dashboard ===");
        System.out.println("Welcome, " + emp.getName());

        // Sort newest → oldest (UC5: Comparator + Streams)
        List<Payslip> top3 = payslips.stream()
                .sorted(Comparator.comparing(Payslip::getGeneratedAt).reversed())
                .limit(3)
                .toList();

        System.out.println("\nRecent Payslips (Top 3):");
        top3.forEach(p -> System.out.println("• NET = " + p.net()));

        double ytd = payslips.stream().mapToDouble(Payslip::net).sum();
        System.out.println("\nYTD Earnings: " + ytd);
    }
}
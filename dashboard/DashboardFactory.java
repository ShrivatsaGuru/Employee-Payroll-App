package dashboard;

import employee.Employee;

/**
 * UC5: Abstract Factory for dashboards.
 */
public class DashboardFactory {

    public static Dashboard getDashboard(Employee emp) {
        if ("MANAGER".equalsIgnoreCase(emp.getRole())) {
            return new ManagerDashboard();
        }
        return new EmployeeDashboard();
    }
}
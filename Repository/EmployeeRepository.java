/*
This class serves as a repository for Employee objects
allowing for efficient storage and retrieval based on employee ID and name.
It uses two HashMaps to maintain the mappings of employee IDs 
and names to their corresponding Employee objects.

Version: 1.0
Author: Shrivatsa Guru
 */
package repository;
import employee.Employee;
import java.util.HashMap;

public class EmployeeRepository {

    private static HashMap<Integer, Employee> byId = new HashMap<>();
    private static HashMap<String, Employee> byName = new HashMap<>();

    public static void addEmployee(Employee employee) {
        byId.put(employee.getEmpId(), employee);
        byName.put(employee.getName(), employee);
    }

    public static Employee getEmployeeById(int empId) {
        return byId.get(empId);
    }

    public static Employee getEmployeeByName(String name) {
        return byName.get(name);
    }
    public static boolean validateCredentials(String userName, String passwordHash) {
        Employee employee = byName.get(userName);
        if (employee != null) {
            return employee.getPassword().equals(passwordHash);
        }
        return false;
    }

}

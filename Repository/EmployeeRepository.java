package repository;

import employee.Employee;
import java.util.HashMap;
import java.util.Map;

public class EmployeeRepository {

    private static final Map<Integer, Employee> byId   = new HashMap<>();
    private static final Map<String, Employee>  byName = new HashMap<>();

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

    public static boolean existsByName(String name) {
        return byName.containsKey(name);
    }

    public static int count() {
        return byId.size();
    }
}
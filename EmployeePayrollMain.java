/*
Main Class

* Entry point of Use Case 1.

* Execution Flow:
* 1. Take input from user
* 2. Validate input
* 3. Create objects
* 4. Persist data
* 5. Display confirmation

* @author Shrivatsa Guru
* @version 1.0
 */
import java.util.*;

public class EmployeePayrollMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" === USE CASE 1: EMPLOYEE REGISTRATION === ");
        try {
            System.out.print("Enter Employee ID: ");
            int empId = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            System.out.print("Enter Phone Number: ");
            int phoneNumber = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Username: ");
            String userName = sc.nextLine();
            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            Validator validator = new Validator();
            if (validator.validateEmail(email) && validator.validatePhoneNumber(phoneNumber)) {
                String hashedPassword = validator.hashPassword(password);
                Employee employee = new Employee(empId, name, email, phoneNumber, userName, hashedPassword);
                EmployeeRepository.addEmployee(employee);
                System.out.println("\nEmployee Registration Successful!");
                employee.displayEmployeeDetails();
            }
        } catch (ValidationException e) {
            System.out.println("\nValidation Failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nError saving employee data!");
        }
    }
}

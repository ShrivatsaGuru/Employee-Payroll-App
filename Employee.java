/*
---------Employee Class---------
This class represents an Employee entity.
* Core OOP concept introduced here:
* Encapsulation

Data is kept private and controlled through the class.

* Version: 1.0
* @author Shrivatsa Guru
 */
public class Employee {

    private int empId;
    private String name;
    private String email;
    private int phoneNumber;
    private String userName;
    private String password;

    private UserAccount userAccount;

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public int getEmpId() {
        return this.empId;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public Employee(int empId, String name, String email, int phoneNumber, String userName, String password) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Username: " + userName);
    }

}

package main;

import employee.*;
import user.*;
import repository.*;
import validation.*;
import session.Session;

// ---- UC3 imports ----
import payroll.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegistrationService reg = new RegistrationService();
        AuthService auth = new AuthService();
        PayrollService payroll = new PayrollService();

        try (Scanner sc = new Scanner(System.in)) {
            // ---------- UC1: Registration ----------
            System.out.println("=== UC1: Register Employees (blank name to stop) ===");
            while (true) {
                System.out.print("Name (username): ");
                String name = sc.nextLine().trim();
                if (name.isEmpty()) break;

                System.out.print("Email: ");
                String email = sc.nextLine().trim();

                System.out.print("Phone (10 digits): ");
                String phone = sc.nextLine().trim();

                System.out.print("Role (EMPLOYEE/MANAGER): ");
                String role = sc.nextLine().trim();

                System.out.print("Password: ");
                String pass = sc.nextLine();

                Employee e = reg.register(name, email, phone, role, pass);
                System.out.println(e != null ? "[UC1] Registered ✔ " + e : "[UC1] Registration failed ✖ (check inputs)");
                System.out.println();
            }

            if (EmployeeRepository.count() == 0) {
                System.out.println("No users registered. Exiting.");
                return;
            }

            // ---------- UC2 + UC3: Login then (optionally) generate payslip ----------
            System.out.println("\n=== UC2: Login (type 'exit' to quit) ===");
            while (true) {
                System.out.print("Username: ");
                String u = sc.nextLine().trim();
                if ("exit".equalsIgnoreCase(u)) break;

                System.out.print("Password: ");
                String p = sc.nextLine();

                Session s = auth.loginByName(u, p); // uses repository under the hood
                if (s != null) {
                    // ---- UC3 prompt: simple, optional step after successful auth ----
                    Employee emp = EmployeeRepository.getEmployeeByName(u);
                    System.out.print("Generate payslip now? (y/n): ");
                    String ans = sc.nextLine().trim();
                    if (ans.equalsIgnoreCase("y")) {
                        double basic = readDouble(sc, "Enter Basic Pay: ");
                        double[] allowances = readDoubleList(sc, "Enter Allowances (comma-separated, or blank): ");
                        double[] otherDeds  = readDoubleList(sc, "Enter Other Deductions (comma-separated, or blank): ");

                        SalaryComponents scmp = new SalaryComponents()
                                .withBasic(basic)
                                .withAllowances(allowances)
                                .withDeductions(otherDeds);

                        System.out.println(payroll.generatePayslip(emp, scmp)); // prints nicely
                    }
                }
                System.out.println("-----------------------------------");
            }
        }
    }

    // ---- Small helpers to keep main tidy ----
    private static double readDouble(Scanner sc, String prompt) {
        System.out.print(prompt);
        String in = sc.nextLine().trim();
        try { return Double.parseDouble(in); } catch (Exception e) { return 0.0; }
    }

    private static double[] readDoubleList(Scanner sc, String prompt) {
        System.out.print(prompt);
        String line = sc.nextLine().trim();
        if (line.isEmpty()) return new double[0];
        String[] parts = line.split(",");
        double[] out = new double[parts.length];
        for (int i = 0; i < parts.length; i++) {
            try { out[i] = Double.parseDouble(parts[i].trim()); }
            catch (Exception e) { out[i] = 0.0; }
        }
        return out;
    }
}
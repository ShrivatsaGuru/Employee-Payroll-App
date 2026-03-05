package main;

import employee.*;
import user.*;
import repository.*;
import validation.*;
import session.Session;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegistrationService reg = new RegistrationService();
        AuthService auth = new AuthService();

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

            // ---------- UC2: Authentication ----------
            System.out.println("\n=== UC2: Login (type 'exit' to quit) ===");
            while (true) {
                System.out.print("Username: ");
                String u = sc.nextLine().trim();
                if ("exit".equalsIgnoreCase(u)) break;

                System.out.print("Password: ");
                String p = sc.nextLine();

                Session s = auth.loginByName(u, p); // uses repository HashMaps internally
                if (s != null) {
                    System.out.println("Session started for " + s.getUsername() + " (expired? " + s.isExpired() + ")");
                }
                System.out.println("-----------------------------------");
            }
        }
    }
}
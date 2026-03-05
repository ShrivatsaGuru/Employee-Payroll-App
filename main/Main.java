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
            System.out.println("=== UC1: Employee Registration ===");
            System.out.println("Enter users (blank username to stop).");
                System.out.print("Username: ");
                String username = sc.nextLine().trim();

                System.out.print("Email: ");
                String email = sc.nextLine().trim();

                System.out.print("Phone (10 digits): ");
                String phone = sc.nextLine().trim();

                System.out.print("Role (EMPLOYEE/MANAGER): ");
                String role = sc.nextLine().trim();

                System.out.print("Password: ");
                String pass = sc.nextLine();

                boolean ok = reg.register(username, email, phone, role, pass);
                System.out.println(ok ? "User Registered " : " Registration failed.(check inputs)");
                System.out.println();
                
            if (reg.count() == 0) {
                System.out.println("No users registered. Exiting.");
                return;
            }

            System.out.println("\n=== UC2: Login & Authentication ===");
            System.out.println("Type 'exit' as username to quit.");
            while (true) {
                System.out.print("Username: ");
                String u = sc.nextLine().trim();
                if ("exit".equalsIgnoreCase(u)) break;
                User found = reg.find(u);
                if (found == null) {
                    System.out.println("[Auth] Unknown user");
                    continue;
                }
                System.out.print("Password: ");
                String p = sc.nextLine();

                Session s = auth.login(found, p);
                if (s != null) {
                    System.out.println("Session started for " + s.getUsername() + " (expired? " + s.isExpired() + ")");
                    System.out.println(found.getRole().equals("MANAGER") ? "-> Manager Dashboard" : "-> Employee Dashboard");
                } else {
                    System.out.println("Login failed. Try again.");
                }
            }
        }
    }
}
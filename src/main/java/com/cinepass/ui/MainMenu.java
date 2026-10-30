package com.cinepass.ui;

import com.cinepass.dao.UserDao;
import com.cinepass.model.User;

import java.util.Scanner;

public class MainMenu {
    private final UserDao userDao;
    private final Scanner scanner;

    public MainMenu(UserDao userDao, Scanner scanner) {
        this.userDao = userDao;
        this.scanner = scanner;
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("===== CINEPASS =====");
            System.out.println("1. Register Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> register();
                case "2" -> login();
                case "3" -> {
                    System.out.println("Thank you for using CinePass. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void register() {
        System.out.println();
        System.out.println("----- REGISTER ACCOUNT -----");
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        if (username.isEmpty()) {
            System.out.println("Username cannot be empty.");
            return;
        }
        if (userDao.usernameExists(username)) {
            System.out.println("Username already taken.");
            return;
        }
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();
        if (password.isEmpty()) {
            System.out.println("Password cannot be empty.");
            return;
        }
        String role = selectRole();
        User newUser = new User(0, username, password, role, "PENDING");
        if (userDao.registerUser(newUser)) {
            System.out.println("Registration successful! Your account status is PENDING.");
        } else {
            System.out.println("Registration failed. Please try again.");
        }
    }

    private String selectRole() {
        while (true) {
            System.out.println("Select role:");
            System.out.println("1. CASHIER");
            System.out.println("2. CUSTOMER");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();
            if (choice.equals("1")) {
                return "CASHIER";
            }
            if (choice.equals("2")) {
                return "CUSTOMER";
            }
            System.out.println("Invalid choice. Enter 1 or 2.");
        }
    }

    private void login() {
        System.out.println();
        System.out.println("----- LOGIN -----");
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();
        User user = userDao.login(username, password);
        if (user == null) {
            System.out.println("Invalid username or password.");
            return;
        }
        userSession(user);
    }

    private void userSession(User user) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println();
            System.out.println("Welcome, " + user.username() + "!");
            System.out.println("Role   : " + user.roles());
            System.out.println("Status : " + user.status());
            System.out.println("1. Logout");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();
            if (choice.equals("1")) {
                System.out.println("You have been logged out.");
                loggedIn = false;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

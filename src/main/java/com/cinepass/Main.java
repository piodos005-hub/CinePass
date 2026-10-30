package com.cinepass;

import com.cinepass.dao.DatabaseConnection;
import com.cinepass.dao.UserDao;
import com.cinepass.ui.MainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.createTables();
        Scanner scanner = new Scanner(System.in);
        UserDao userDao = new UserDao();
        new MainMenu(userDao, scanner).start();
        scanner.close();
    }
}

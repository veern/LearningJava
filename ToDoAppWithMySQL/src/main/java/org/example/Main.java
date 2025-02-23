package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/sys";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("I made it!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}
package com.smartshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class to manage MySQL database connections using JDBC.
 */
public class DBConnection {
    // Database credentials 
    private static final String URL = "jdbc:mysql://localhost:3306/SmartShopDB";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    /**
     * Establishes and returns a connection to the MySQL database.
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Database Connection Error: " + e.getMessage());
        }
        return connection;
    }
}
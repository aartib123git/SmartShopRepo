package com.smartshop.dao;

import java.sql.*;
import com.smartshop.entity.Product;
import com.smartshop.util.DBConnection;

public class AdminDAO {
    // User Story 3.1: Add New Product
    public void addProduct(Product product) throws SQLException {
        String query = "INSERT INTO product (product_id, name, description, price, quantity) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, product.getProductId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDescription());
            ps.setDouble(4, product.getPrice());
            ps.setInt(5, product.getQuantity());
            ps.executeUpdate();
        }
    }

    // User Story 3.2: View Product Stock
    public int getProductStock(int productId) throws SQLException {
        String query = "SELECT quantity FROM product WHERE product_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt("quantity");
        }
        return -1;
    }

    // User Story 3.3: View Registered Users (Excluding Passwords)
    public void displayAllUsers() throws SQLException {
        String query = "SELECT user_id, first_name, last_name, city, email, mobile FROM users";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("User ID | Name | City | Email | Mobile");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " " + rs.getString(3) + 
                                   " | " + rs.getString(4) + " | " + rs.getString(5) + " | " + rs.getString(6));
            }
        }
    }

    // User Story 3.5 & 3.6: Update and Delete
    public void updateProduct(int id, String field, Object value) throws SQLException {
        String query = "UPDATE product SET " + field + " = ? WHERE product_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, value);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public void deleteProduct(int productId) throws SQLException {
        String query = "DELETE FROM product WHERE product_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, productId);
            ps.executeUpdate();
        }
    }
}
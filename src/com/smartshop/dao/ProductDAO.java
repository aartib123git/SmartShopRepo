package com.smartshop.dao;

import com.smartshop.entity.Product;
import com.smartshop.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // Requirement 2.1: View sorted list of products 
    public List<Product> getAllProductsSorted() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products ORDER BY name ASC";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                products.add(new Product(rs.getInt("product_id"), rs.getString("name"),
                        rs.getString("description"), rs.getDouble("price"), rs.getInt("quantity")));
            }
        }
        return products;
    }

    // Requirement 2.4: Search Products by Name or Keyword 
    public List<Product> searchProducts(String keyword) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE name LIKE ? OR description LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt("product_id"), rs.getString("name"),
                        rs.getString("description"), rs.getDouble("price"), rs.getInt("quantity")));
            }
        }
        return products;
    }
    
    // Helper method for purchase
    public Product getProductById(int id) throws SQLException {
        String sql = "SELECT * FROM products WHERE product_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt("product_id"), rs.getString("name"),
                        rs.getString("description"), rs.getDouble("price"), rs.getInt("quantity"));
            }
        }
        return null;
    }
}
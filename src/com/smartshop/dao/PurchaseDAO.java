package com.smartshop.dao;

import com.smartshop.util.DBConnection;
import java.sql.*;

public class PurchaseDAO {

    // Requirement 2.2: Add Product to Cart (Save as Purchase)
    public boolean purchaseProduct(int userId, int productId, int quantity) throws SQLException {
        String insertPurchaseSQL = "INSERT INTO purchases (user_id, product_id, quantity) VALUES (?, ?, ?)";
        String updateStockSQL = "UPDATE products SET quantity = quantity - ? WHERE product_id = ? AND quantity >= ?";

        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false); // Start transaction

            // 1. Update stock
            try (PreparedStatement updateStmt = conn.prepareStatement(updateStockSQL)) {
                updateStmt.setInt(1, quantity);
                updateStmt.setInt(2, productId);
                updateStmt.setInt(3, quantity);
                int updatedRows = updateStmt.executeUpdate();
                if (updatedRows == 0) throw new SQLException("Insufficient stock");
            }

            // 2. Record purchase
            try (PreparedStatement insertStmt = conn.prepareStatement(insertPurchaseSQL)) {
                insertStmt.setInt(1, userId);
                insertStmt.setInt(2, productId);
                insertStmt.setInt(3, quantity);
                insertStmt.executeUpdate();
            }

            conn.commit(); // Commit transaction
            return true;
        } catch (SQLException e) {
            if (conn != null) conn.rollback();
            throw e;
        } finally {
            if (conn != null) conn.close();
        }
    }
}
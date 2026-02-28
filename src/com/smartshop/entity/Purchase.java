package com.smartshop.entity;

import java.time.LocalDate;

public class Purchase {
	 private String purchaseId;        // Unique identifier
	    private String customerId;        // Who made the purchase
	    private String productId;         // What product was purchased
	    private int quantity;             // How many units
	    private double unitPrice;         // Price per unit at time of purchase
	    private double totalAmount;       // Calculated = quantity * unitPrice
	    private LocalDate purchaseDate;   // When the purchase was made
	    private String paymentMethod;     // e.g., Credit Card, UPI, Cash
	    private String status;            // e.g., Pending, Completed, Cancelled

	    // Constructor
	    public Purchase() {
	    	
	    }
	    
	    public Purchase(String purchaseId, String customerId, String productId,
	                    int quantity, double unitPrice, LocalDate purchaseDate,
	                    String paymentMethod, String status) {
	        this.purchaseId = purchaseId;
	        this.customerId = customerId;
	        this.productId = productId;
	        this.quantity = quantity;
	        this.unitPrice = unitPrice;
	        this.totalAmount = quantity * unitPrice;
	        this.purchaseDate = purchaseDate;
	        this.paymentMethod = paymentMethod;
	        this.status = status;
	    }

	    // Getters and setters
	    public String getPurchaseId() { return purchaseId; }
	    public String getCustomerId() { return customerId; }
	    public String getProductId() { return productId; }
	    public int getQuantity() { return quantity; }
	    public double getUnitPrice() { return unitPrice; }
	    public double getTotalAmount() { return totalAmount; }
	    public LocalDate getPurchaseDate() { return purchaseDate; }
	    public String getPaymentMethod() { return paymentMethod; }
	    public String getStatus() { return status; }

	    public void setStatus(String status) { this.status = status; }

		@Override
		public String toString() {
			return "Purchase [purchaseId=" + purchaseId + ", customerId=" + customerId + ", productId=" + productId
					+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalAmount=" + totalAmount
					+ ", purchaseDate=" + purchaseDate + ", paymentMethod=" + paymentMethod + ", status=" + status
					+ "]";
		}
	    
	}


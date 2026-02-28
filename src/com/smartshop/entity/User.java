package com.smartshop.entity;

/**
 * Represents a User in the Smart Shop application.
 * Adheres to requirements for registration and admin monitoring.
 */
public class User {
    // Unique identifier for the user as required by DB structure [cite: 415]
    private int userId;
    
    // Personal details required for registration 
    private String firstName;
    private String lastName;
    private String username; // Must be unique 
    private String password;
    private String city;
    private String email;    // Requires format validation 
    private String mobile;   // Must be 10 digits 

    // Default constructor
    public User() {}

    // Constructor with all fields for database retrieval
    public User(int userId, String firstName, String lastName, String username, 
                String password, String city, String email, String mobile) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.city = city;
        this.email = email;
        this.mobile = mobile;
    }

    // Getters and Setters 
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

	@Override
	public String toString() {
		
		// For Admin Story 3.3: View Registered Users
		// Note: Password is excluded from display for security 
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", city=" + city + ", email=" + email + ", mobile=" + mobile
				+ "]";
	}
    

}

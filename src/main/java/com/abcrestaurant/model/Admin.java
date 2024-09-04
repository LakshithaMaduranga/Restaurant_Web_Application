package com.abcrestaurant.model;

public class Admin extends User {

    // Constructor
    public Admin() {
        super(); // Call the parent class (User) constructor
    }

    public Admin(int userID, String username, String password, String email, String contactInfo, String role) {
        super(userID, username, password, email, contactInfo, role); // Call the parent class constructor
    }

    // Admin-specific methods

    // Method to manage dishes in the restaurant's menu
    public void manageDishes() {
        // Logic to add, edit, and remove dishes from the menu
        System.out.println("Managing dishes...");
    }

    // Method to manage user accounts
    public void manageUsers() {
        // Logic to view, promote, and manage user accounts
        System.out.println("Managing users...");
    }

    // Method to manage customer orders
    public void manageOrders() {
        // Logic to monitor and manage customer orders
        System.out.println("Managing orders...");
    }

    // Method to view and analyze reports
    public void viewReports() {
        // Logic to analyze sales and customer data
        System.out.println("Viewing reports...");
    }

    // Method to configure system settings
    public void systemSettings() {
        // Logic to configure system settings and preferences
        System.out.println("Configuring system settings...");
    }

    // Override toString() method for better output readability
    @Override
    public String toString() {
        return "Admin{" +
                "userID=" + getUserID() +
                ", username='" + getUsername() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", contactInfo='" + getContactInfo() + '\'' +
                ", role='" + getRole() + '\'' +
                '}';
    }
}

package com.abcrestaurant.model;

public class Customer extends User {
    private int customerID;
    private String name;

    // Constructor
    public Customer() {
        super(); // Call the parent class (User) constructor
    }

    // Parameterized constructor with userID and other parameters
    public Customer(int userID, String username, String password, String email, String contactInfo, String role, int customerID, String name) {
        super(userID, username, password, email, contactInfo, role); // Call the parent class (User) constructor with parameters
        this.customerID = customerID;
        this.name = name;
    }

    // Getters and Setters
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Additional methods specific to Customer
    public void makeReservation() {
        // Implement reservation logic here
    }

    public void submitQuery() {
        // Implement query submission logic here
    }

    public void searchServices() {
        // Implement service search logic here
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", name='" + name + '\'' +
                ", username='" + getUsername() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", role='" + getRole() + '\'' +
                ", contactInfo='" + getContactInfo() + '\'' +
                '}';
    }
}

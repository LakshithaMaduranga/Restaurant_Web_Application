package com.abcrestaurant.model;

public class Staff extends User {
    private int staffID;
    private String department;

    // Constructor
    public Staff(int userID, String username, String password, String email, String contactInfo, String role, int staffID, String department) {
        super(userID, username, password, email, contactInfo, role); // Call the parent class (User) constructor
        this.staffID = staffID;
        this.department = department;
    }

    // Getters and Setters
    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Additional methods specific to Staff
    public void manageReservation() {
        // Implement reservation management logic here
    }

    public void respondToQuery() {
        // Implement query response logic here
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffID=" + staffID +
                ", department='" + department + '\'' +
                ", username='" + getUsername() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", role='" + getRole() + '\'' +
                ", contactInfo='" + getContactInfo() + '\'' +
                '}';
    }
}

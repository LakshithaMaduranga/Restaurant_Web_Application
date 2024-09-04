package com.abcrestaurant.model;

public class User {
    private int userID;
    private String username;
    private String password;
    private String email;
    private String contactInfo;
    private String role;

    // No-argument constructor
    public User() {
    }

    // Parameterized constructor
    public User(int userID, String username, String password, String email, String contactInfo, String role) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.contactInfo = contactInfo;
        this.role = role;
    }

    // Getters and setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

package com.abcrestaurant.model;

public class User {
    private int userID;
    private String username;
    private String email;
    private String role;
    private String password;
    private String contactInfo;

    // Default constructor
    public User() {}

    // Constructor with userID (for update operations)
    public User(int userID, String username, String email, String role, String password, String contactInfo) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.role = role;
        this.password = password;
        this.contactInfo = contactInfo;
    }

    // Constructor without userID (for insert operations)
    public User(String username, String email, String role, String password, String contactInfo) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.password = password;
        this.contactInfo = contactInfo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}

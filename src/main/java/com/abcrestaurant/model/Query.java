package com.abcrestaurant.model;

public class Query {
    private int queryID;
    private int userID;  // Add this field to store the user ID
    private String customerName;
    private String email;
    private String subject;
    private String message;
    private String response;
    private String status;

    // Default constructor
    public Query() {
    }

    // Constructor for adding a new query (no response or status initially)
    public Query(String customerName, String email, String subject, String message) {
        this.customerName = customerName;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.status = "Pending";  // Default status
    }

    // Constructor for retrieving or updating a query (including all fields)
    public Query(int queryID, String customerName, String email, String subject, String message, String response, String status) {
        this.queryID = queryID;
        this.customerName = customerName;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.response = response;
        this.status = status;
    }

    // Getters and Setters
    public int getQueryID() {
        return queryID;
    }

    public void setQueryID(int queryID) {
        this.queryID = queryID;
    }

    public int getUserID() {  // Getter for userID
        return userID;
    }

    public void setUserID(int userID) {  // Setter for userID
        this.userID = userID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

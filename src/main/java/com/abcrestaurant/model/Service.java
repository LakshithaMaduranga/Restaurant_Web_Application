package com.abcrestaurant.model;

public class Service {
    private int serviceID;
    private String serviceName;
    private String description;
    private double price;

    // Default constructor
    public Service() {
    }

    // Constructor to initialize all fields
    public Service(int serviceID, String serviceName, String description, double price) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
    }

    // Getters and Setters
    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceID=" + serviceID +
                ", serviceName='" + serviceName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}

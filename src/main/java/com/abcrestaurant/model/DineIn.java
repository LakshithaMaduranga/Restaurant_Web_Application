package com.abcrestaurant.model;

public class DineIn extends Service {
    private int tableNumber;
    private int numberOfGuests;

    public DineIn() {
    }

    public DineIn(int serviceID, String serviceName, String description, double price, int tableNumber, int numberOfGuests) {
        super(serviceID, serviceName, description, price);
        this.tableNumber = tableNumber;
        this.numberOfGuests = numberOfGuests;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    @Override
    public String toString() {
        return "DineIn{" +
                "tableNumber=" + tableNumber +
                ", numberOfGuests=" + numberOfGuests +
                ", serviceID=" + getServiceID() +
                ", serviceName='" + getServiceName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}

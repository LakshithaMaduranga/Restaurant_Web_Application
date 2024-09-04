package com.abcrestaurant.model;

public class Delivery extends Service {
    private String deliveryAddress;
    private String deliveryTime;

    public Delivery() {
    }

    public Delivery(int serviceID, String serviceName, String description, double price, String deliveryAddress, String deliveryTime) {
        super(serviceID, serviceName, description, price);
        this.deliveryAddress = deliveryAddress;
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryAddress='" + deliveryAddress + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", serviceID=" + getServiceID() +
                ", serviceName='" + getServiceName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}

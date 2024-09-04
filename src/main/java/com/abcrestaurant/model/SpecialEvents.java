package com.abcrestaurant.model;

public class SpecialEvents extends Service {
    private String eventDate;
    private String eventLocation;

    public SpecialEvents() {
    }

    public SpecialEvents(int serviceID, String serviceName, String description, double price, String eventDate, String eventLocation) {
        super(serviceID, serviceName, description, price);
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    @Override
    public String toString() {
        return "SpecialEvents{" +
                "eventDate='" + eventDate + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", serviceID=" + getServiceID() +
                ", serviceName='" + getServiceName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}

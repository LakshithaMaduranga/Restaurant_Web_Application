package com.abcrestaurant.dao;

import com.abcrestaurant.model.SpecialEvents;
import com.abcrestaurant.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialEventsDAO {

    // Method to add a new special event
    public boolean addSpecialEvent(SpecialEvents event) {
        boolean rowInserted = false;
        String sql = "INSERT INTO SpecialEvents (serviceName, description, price, eventDate, eventLocation) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, event.getServiceName());
            statement.setString(2, event.getDescription());
            statement.setDouble(3, event.getPrice());
            statement.setString(4, event.getEventDate());
            statement.setString(5, event.getEventLocation());

            rowInserted = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    // Method to delete a special event by ID
    public boolean deleteSpecialEvent(int serviceID) {
        boolean rowDeleted = false;
        String sql = "DELETE FROM SpecialEvents WHERE serviceID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, serviceID);

            rowDeleted = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }

    // Method to retrieve a special event by ID
    public SpecialEvents getSpecialEventById(int serviceID) {
        SpecialEvents event = null;
        String sql = "SELECT * FROM SpecialEvents WHERE serviceID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, serviceID);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                event = new SpecialEvents();
                event.setServiceID(resultSet.getInt("serviceID"));
                event.setServiceName(resultSet.getString("serviceName"));
                event.setDescription(resultSet.getString("description"));
                event.setPrice(resultSet.getDouble("price"));
                event.setEventDate(resultSet.getString("eventDate"));
                event.setEventLocation(resultSet.getString("eventLocation"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return event;
    }

    // Method to update a special event
    public boolean updateSpecialEvent(SpecialEvents event) {
        boolean rowUpdated = false;
        String sql = "UPDATE SpecialEvents SET serviceName = ?, description = ?, price = ?, eventDate = ?, eventLocation = ? WHERE serviceID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, event.getServiceName());
            statement.setString(2, event.getDescription());
            statement.setDouble(3, event.getPrice());
            statement.setString(4, event.getEventDate());
            statement.setString(5, event.getEventLocation());
            statement.setInt(6, event.getServiceID());

            rowUpdated = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }

    // Method to retrieve all special events
    public List<SpecialEvents> getAllSpecialEvents() {
        List<SpecialEvents> events = new ArrayList<>();
        String sql = "SELECT * FROM SpecialEvents";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                SpecialEvents event = new SpecialEvents();
                event.setServiceID(resultSet.getInt("serviceID"));
                event.setServiceName(resultSet.getString("serviceName"));
                event.setDescription(resultSet.getString("description"));
                event.setPrice(resultSet.getDouble("price"));
                event.setEventDate(resultSet.getString("eventDate"));
                event.setEventLocation(resultSet.getString("eventLocation"));

                events.add(event);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return events;
    }
}

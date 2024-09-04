package com.abcrestaurant.dao;

import com.abcrestaurant.model.Delivery;
import com.abcrestaurant.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO {

    // Method to add a new delivery
    public boolean addDelivery(Delivery delivery) {
        boolean rowInserted = false;
        String sql = "INSERT INTO Delivery (serviceName, description, price, deliveryAddress, deliveryTime) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, delivery.getServiceName());
            statement.setString(2, delivery.getDescription());
            statement.setDouble(3, delivery.getPrice());
            statement.setString(4, delivery.getDeliveryAddress());
            statement.setString(5, delivery.getDeliveryTime());

            rowInserted = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    // Method to delete a delivery by ID
    public boolean deleteDelivery(int serviceID) {
        boolean rowDeleted = false;
        String sql = "DELETE FROM Delivery WHERE serviceID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, serviceID);

            rowDeleted = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }

    // Method to retrieve a delivery by ID
    public Delivery getDeliveryById(int serviceID) {
        Delivery delivery = null;
        String sql = "SELECT * FROM Delivery WHERE serviceID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, serviceID);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                delivery = new Delivery();
                delivery.setServiceID(resultSet.getInt("serviceID"));
                delivery.setServiceName(resultSet.getString("serviceName"));
                delivery.setDescription(resultSet.getString("description"));
                delivery.setPrice(resultSet.getDouble("price"));
                delivery.setDeliveryAddress(resultSet.getString("deliveryAddress"));
                delivery.setDeliveryTime(resultSet.getString("deliveryTime"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return delivery;
    }

    // Method to update a delivery
    public boolean updateDelivery(Delivery delivery) {
        boolean rowUpdated = false;
        String sql = "UPDATE Delivery SET serviceName = ?, description = ?, price = ?, deliveryAddress = ?, deliveryTime = ? WHERE serviceID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, delivery.getServiceName());
            statement.setString(2, delivery.getDescription());
            statement.setDouble(3, delivery.getPrice());
            statement.setString(4, delivery.getDeliveryAddress());
            statement.setString(5, delivery.getDeliveryTime());
            statement.setInt(6, delivery.getServiceID());

            rowUpdated = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }

    // Method to retrieve all deliveries
    public List<Delivery> getAllDeliveries() {
        List<Delivery> deliveries = new ArrayList<>();
        String sql = "SELECT * FROM Delivery";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Delivery delivery = new Delivery();
                delivery.setServiceID(resultSet.getInt("serviceID"));
                delivery.setServiceName(resultSet.getString("serviceName"));
                delivery.setDescription(resultSet.getString("description"));
                delivery.setPrice(resultSet.getDouble("price"));
                delivery.setDeliveryAddress(resultSet.getString("deliveryAddress"));
                delivery.setDeliveryTime(resultSet.getString("deliveryTime"));

                deliveries.add(delivery);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return deliveries;
    }
}

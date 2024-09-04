package com.abcrestaurant.dao;

import com.abcrestaurant.model.Service;
import com.abcrestaurant.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO {

    // Method to add a new service
    public boolean addService(Service service) {
        boolean rowInserted = false;
        String sql = "INSERT INTO Services (serviceName, description, price) VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, service.getServiceName());
            statement.setString(2, service.getDescription());
            statement.setDouble(3, service.getPrice());

            rowInserted = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    // Method to delete a service by ID
    public boolean deleteService(int serviceID) {
        boolean rowDeleted = false;
        String sql = "DELETE FROM Services WHERE serviceID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, serviceID);

            rowDeleted = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }

    // Method to retrieve a service by ID
    public Service getServiceById(int serviceID) {
        Service service = null;
        String sql = "SELECT * FROM Services WHERE serviceID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, serviceID);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                service = new Service();
                service.setServiceID(resultSet.getInt("serviceID"));
                service.setServiceName(resultSet.getString("serviceName"));
                service.setDescription(resultSet.getString("description"));
                service.setPrice(resultSet.getDouble("price"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return service;
    }

    // Method to update a service
    public boolean updateService(Service service) {
        boolean rowUpdated = false;
        String sql = "UPDATE Services SET serviceName = ?, description = ?, price = ? WHERE serviceID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, service.getServiceName());
            statement.setString(2, service.getDescription());
            statement.setDouble(3, service.getPrice());
            statement.setInt(4, service.getServiceID());

            rowUpdated = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }

    // Method to retrieve all services
    public List<Service> getAllServices() {
        List<Service> services = new ArrayList<>();
        String sql = "SELECT * FROM Services";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Service service = new Service();
                service.setServiceID(resultSet.getInt("serviceID"));
                service.setServiceName(resultSet.getString("serviceName"));
                service.setDescription(resultSet.getString("description"));
                service.setPrice(resultSet.getDouble("price"));

                services.add(service);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return services;
    }
}

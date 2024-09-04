package com.abcrestaurant.dao;

import com.abcrestaurant.model.DineIn;
import com.abcrestaurant.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DineInDAO {

    // Method to add a new dine-in service
    public boolean addDineIn(DineIn dineIn) {
        boolean rowInserted = false;
        String sql = "INSERT INTO DineIn (serviceName, description, price, tableNumber, numberOfGuests) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, dineIn.getServiceName());
            statement.setString(2, dineIn.getDescription());
            statement.setDouble(3, dineIn.getPrice());
            statement.setInt(4, dineIn.getTableNumber());
            statement.setInt(5, dineIn.getNumberOfGuests());

            rowInserted = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    // Method to delete a dine-in service by ID
    public boolean deleteDineIn(int serviceID) {
        boolean rowDeleted = false;
        String sql = "DELETE FROM DineIn WHERE serviceID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, serviceID);

            rowDeleted = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }

    // Method to retrieve a dine-in service by ID
    public DineIn getDineInById(int serviceID) {
        DineIn dineIn = null;
        String sql = "SELECT * FROM DineIn WHERE serviceID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, serviceID);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                dineIn = new DineIn();
                dineIn.setServiceID(resultSet.getInt("serviceID"));
                dineIn.setServiceName(resultSet.getString("serviceName"));
                dineIn.setDescription(resultSet.getString("description"));
                dineIn.setPrice(resultSet.getDouble("price"));
                dineIn.setTableNumber(resultSet.getInt("tableNumber"));
                dineIn.setNumberOfGuests(resultSet.getInt("numberOfGuests"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return dineIn;
    }

    // Method to update a dine-in service
    public boolean updateDineIn(DineIn dineIn) {
        boolean rowUpdated = false;
        String sql = "UPDATE DineIn SET serviceName = ?, description = ?, price = ?, tableNumber = ?, numberOfGuests = ? WHERE serviceID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, dineIn.getServiceName());
            statement.setString(2, dineIn.getDescription());
            statement.setDouble(3, dineIn.getPrice());
            statement.setInt(4, dineIn.getTableNumber());
            statement.setInt(5, dineIn.getNumberOfGuests());
            statement.setInt(6, dineIn.getServiceID());

            rowUpdated = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }

    // Method to retrieve all dine-in services
    public List<DineIn> getAllDineIns() {
        List<DineIn> dineIns = new ArrayList<>();
        String sql = "SELECT * FROM DineIn";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                DineIn dineIn = new DineIn();
                dineIn.setServiceID(resultSet.getInt("serviceID"));
                dineIn.setServiceName(resultSet.getString("serviceName"));
                dineIn.setDescription(resultSet.getString("description"));
                dineIn.setPrice(resultSet.getDouble("price"));
                dineIn.setTableNumber(resultSet.getInt("tableNumber"));
                dineIn.setNumberOfGuests(resultSet.getInt("numberOfGuests"));

                dineIns.add(dineIn);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return dineIns;
    }
}

package com.abcrestaurant.dao;

import com.abcrestaurant.model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    private Connection connection;

    public AdminDAO(Connection connection) {
        this.connection = connection;
    }

    // Create a new Admin
    public boolean addAdmin(Admin admin) throws SQLException {
        String query = "INSERT INTO Admins (username, password, email, contactInfo, role) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, admin.getUsername());
            statement.setString(2, admin.getPassword());
            statement.setString(3, admin.getEmail());
            statement.setString(4, admin.getContactInfo());
            statement.setString(5, admin.getRole());

            return statement.executeUpdate() > 0;
        }
    }

    // Get an Admin by ID
    public Admin getAdminById(int adminId) throws SQLException {
        String query = "SELECT * FROM Admins WHERE userID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, adminId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Admin(
                        resultSet.getInt("userID"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("contactInfo"),
                        resultSet.getString("role")
                );
            }
        }
        return null;
    }

    // Update an existing Admin
    public boolean updateAdmin(Admin admin) throws SQLException {
        String query = "UPDATE Admins SET username = ?, password = ?, email = ?, contactInfo = ?, role = ? WHERE userID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, admin.getUsername());
            statement.setString(2, admin.getPassword());
            statement.setString(3, admin.getEmail());
            statement.setString(4, admin.getContactInfo());
            statement.setString(5, admin.getRole());
            statement.setInt(6, admin.getUserID());

            return statement.executeUpdate() > 0;
        }
    }

    // Delete an Admin by ID
    public boolean deleteAdmin(int adminId) throws SQLException {
        String query = "DELETE FROM Admins WHERE userID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, adminId);
            return statement.executeUpdate() > 0;
        }
    }

    // Get all Admins
    public List<Admin> getAllAdmins() throws SQLException {
        String query = "SELECT * FROM Admins";
        List<Admin> admins = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Admin admin = new Admin(
                        resultSet.getInt("userID"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("contactInfo"),
                        resultSet.getString("role")
                );
                admins.add(admin);
            }
        }
        return admins;
    }
}

package com.abcrestaurant.dao;

import com.abcrestaurant.model.User;
import com.abcrestaurant.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // Method to authenticate a user (used for login)
    public User authenticateUser(String username, String password) throws SQLException, ClassNotFoundException {
        User user = null;
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
        
        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {
             
            statement.setString(1, username);
            statement.setString(2, password);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                user = new User();
                user.setUserID(resultSet.getInt("userID"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(resultSet.getString("role"));
                user.setContactInfo(resultSet.getString("contactInfo"));
            }
        }
        return user;
    }

    // Method to register a new user (used for registration)
    public boolean registerUser(User user) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Users (username, password, email, role, contactInfo) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {
             
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getRole());
            statement.setString(5, user.getContactInfo());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }
    }
}

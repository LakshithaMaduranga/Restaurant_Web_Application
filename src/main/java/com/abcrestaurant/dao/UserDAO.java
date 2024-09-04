package com.abcrestaurant.dao;

import com.abcrestaurant.model.User;
import com.abcrestaurant.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Method to validate user credentials
    public User validate(String username, String password) {
        User user = null;
        try {
            Connection connection = DBConnection.initializeDatabase();
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setUserID(resultSet.getInt("userID"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(resultSet.getString("role"));
                user.setContactInfo(resultSet.getString("contactInfo"));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Method to register a new user
    public boolean registerUser(User user) {
        boolean status = false;
        try {
            Connection connection = DBConnection.initializeDatabase();
            String query = "INSERT INTO users (username, password, email, role, contactInfo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword()); // Hash password in production
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setString(5, user.getContactInfo());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                status = true;
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return status;
    }

    // Method to retrieve a user by their ID
    public User getUserById(int userID) {
        User user = null;
        try {
            Connection connection = DBConnection.initializeDatabase();
            String query = "SELECT * FROM users WHERE userID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setUserID(resultSet.getInt("userID"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(resultSet.getString("role"));
                user.setContactInfo(resultSet.getString("contactInfo"));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Method to retrieve a user by their username
    public User getUserByUsername(String username) {
        User user = null;
        try {
            Connection connection = DBConnection.initializeDatabase();
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setUserID(resultSet.getInt("userID"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(resultSet.getString("role"));
                user.setContactInfo(resultSet.getString("contactInfo"));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Method to retrieve all users
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = DBConnection.initializeDatabase();
            String query = "SELECT * FROM users";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getInt("userID"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(resultSet.getString("role"));
                user.setContactInfo(resultSet.getString("contactInfo"));
                users.add(user);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Method to update user information
    public boolean updateUser(User user) {
        boolean status = false;
        try {
            Connection connection = DBConnection.initializeDatabase();
            String query = "UPDATE users SET username = ?, email = ?, role = ?, contactInfo = ? WHERE userID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setString(4, user.getContactInfo());
            preparedStatement.setInt(5, user.getUserID());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                status = true;
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return status;
    }

    // Method to delete a user by their ID
    public boolean deleteUser(int userID) {
        boolean status = false;
        try {
            Connection connection = DBConnection.initializeDatabase();
            String query = "DELETE FROM users WHERE userID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userID);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                status = true;
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return status;
    }
    
 // Method to authenticate a user
    public User authenticateUser(String username, String password) {
        User user = null;
        String query = "SELECT * FROM Users WHERE username = ? AND passwordHash = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setUserID(resultSet.getInt("userID"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("passwordHash"));
                    user.setEmail(resultSet.getString("email"));
                    user.setContactInfo(resultSet.getString("contactInfo"));
                    user.setRole(resultSet.getString("role"));
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return user;
    }
}

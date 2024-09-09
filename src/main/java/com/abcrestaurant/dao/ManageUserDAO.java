package com.abcrestaurant.dao;

import com.abcrestaurant.model.User;
import com.abcrestaurant.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageUserDAO {

    // Insert a new user into the database
    public void insertUser(User user) {
        String sql = "INSERT INTO Users (username, email, role, password, contactInfo) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getRole());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getContactInfo());

            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Select a specific user by ID
    public User selectUser(int userID) {
        User user = null;
        String sql = "SELECT * FROM Users WHERE userID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("userID"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("role"),
                        resultSet.getString("password"),
                        resultSet.getString("contactInfo")
                );
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return user;
    }

    // Select all users from the database
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("userID"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("role"),
                        resultSet.getString("password"),
                        resultSet.getString("contactInfo")
                );
                users.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return users;
    }

    // Update a user's information in the database
    public boolean updateUser(User user) {
        String sql = "UPDATE Users SET username = ?, email = ?, role = ?, password = ?, contactInfo = ? WHERE userID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getRole());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getContactInfo());
            statement.setInt(6, user.getUserID());

            return statement.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete a user from the database by ID
    public boolean deleteUser(int userID) {
        String sql = "DELETE FROM Users WHERE userID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userID);
            return statement.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}

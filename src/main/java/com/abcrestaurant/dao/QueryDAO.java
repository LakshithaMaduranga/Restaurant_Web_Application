package com.abcrestaurant.dao;

import com.abcrestaurant.model.Query;
import com.abcrestaurant.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDAO {

    // Method to add a new query
    public boolean addQuery(Query query) {
        boolean rowInserted = false;
        String sql = "INSERT INTO Queries (userID, customerName, email, subject, message, status) VALUES (?, ?, ?, ?, ?, 'Pending')";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, query.getUserID());
            statement.setString(2, query.getCustomerName());
            statement.setString(3, query.getEmail());
            statement.setString(4, query.getSubject());
            statement.setString(5, query.getMessage());

            rowInserted = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    // Method to retrieve all queries
    public List<Query> getAllQueries() {
        List<Query> queries = new ArrayList<>();
        String sql = "SELECT * FROM Queries";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Query query = new Query();
                query.setQueryID(resultSet.getInt("queryID"));
                query.setUserID(resultSet.getInt("userID"));
                query.setCustomerName(resultSet.getString("customerName"));
                query.setEmail(resultSet.getString("email"));
                query.setSubject(resultSet.getString("subject"));
                query.setMessage(resultSet.getString("message"));
                query.setResponse(resultSet.getString("response"));
                query.setStatus(resultSet.getString("status"));

                queries.add(query);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return queries;
    }

    // Method to retrieve a specific query by ID
    public Query getQueryById(int queryID) {
        Query query = null;
        String sql = "SELECT * FROM Queries WHERE queryID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, queryID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                query = new Query();
                query.setQueryID(resultSet.getInt("queryID"));
                query.setUserID(resultSet.getInt("userID"));
                query.setCustomerName(resultSet.getString("customerName"));
                query.setEmail(resultSet.getString("email"));
                query.setSubject(resultSet.getString("subject"));
                query.setMessage(resultSet.getString("message"));
                query.setResponse(resultSet.getString("response"));
                query.setStatus(resultSet.getString("status"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return query;
    }

    // Method to update a query (e.g., respond to a query)
    public boolean updateQuery(Query query) {
        boolean rowUpdated = false;
        String sql = "UPDATE Queries SET response = ?, status = ? WHERE queryID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, query.getResponse());
            statement.setString(2, query.getStatus());
            statement.setInt(3, query.getQueryID());

            rowUpdated = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }

    // Method to delete a query by ID
    public boolean deleteQuery(int queryID) {
        boolean rowDeleted = false;
        String sql = "DELETE FROM Queries WHERE queryID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, queryID);

            rowDeleted = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }

    // Method to respond to a query by updating the response and status
    public boolean respondToQuery(int queryID, String responseMessage) {
        boolean rowUpdated = false;
        String sql = "UPDATE Queries SET response = ?, status = 'Responded' WHERE queryID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, responseMessage);
            statement.setInt(2, queryID);

            rowUpdated = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }
}

package com.abcrestaurant.dao;

import com.abcrestaurant.model.Reservation;
import com.abcrestaurant.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

    // Method to add a new reservation
    public boolean addReservation(Reservation reservation) {
        boolean rowInserted = false;
        String sql = "INSERT INTO Reservations (userID, customerName, date, time, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, reservation.getUserID());
            statement.setString(2, reservation.getCustomerName());
            statement.setDate(3, java.sql.Date.valueOf(reservation.getDate()));
            statement.setTime(4, java.sql.Time.valueOf(reservation.getTime()));
            statement.setString(5, reservation.getStatus());

            rowInserted = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    // Method to delete a reservation by ID
    public boolean deleteReservation(int reservationID) {
        boolean rowDeleted = false;
        String sql = "DELETE FROM Reservations WHERE reservationID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, reservationID);

            rowDeleted = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }

    // Method to retrieve a reservation by ID
    public Reservation getReservationById(int reservationID) {
        Reservation reservation = null;
        String sql = "SELECT * FROM Reservations WHERE reservationID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, reservationID);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                reservation = new Reservation();
                reservation.setReservationID(resultSet.getInt("reservationID"));
                reservation.setUserID(resultSet.getInt("userID"));
                reservation.setCustomerName(resultSet.getString("customerName"));
                reservation.setDate(resultSet.getDate("date").toLocalDate());
                reservation.setTime(resultSet.getTime("time").toLocalTime());
                reservation.setStatus(resultSet.getString("status"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return reservation;
    }

    // Method to update a reservation
    public boolean updateReservation(Reservation reservation) {
        boolean rowUpdated = false;
        String sql = "UPDATE Reservations SET customerName = ?, date = ?, time = ?, status = ? WHERE reservationID = ?";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, reservation.getCustomerName());
            statement.setDate(2, java.sql.Date.valueOf(reservation.getDate()));
            statement.setTime(3, java.sql.Time.valueOf(reservation.getTime()));
            statement.setString(4, reservation.getStatus());
            statement.setInt(5, reservation.getReservationID());

            rowUpdated = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }

    // Method to retrieve all reservations
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM Reservations";

        try (Connection connection = DBConnection.initializeDatabase();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationID(resultSet.getInt("reservationID"));
                reservation.setUserID(resultSet.getInt("userID"));
                reservation.setCustomerName(resultSet.getString("customerName"));
                reservation.setDate(resultSet.getDate("date").toLocalDate());
                reservation.setTime(resultSet.getTime("time").toLocalTime());
                reservation.setStatus(resultSet.getString("status"));

                reservations.add(reservation);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return reservations;
    }
}

package com.abcrestaurant.controller;

import com.abcrestaurant.dao.UserDAO;
import com.abcrestaurant.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve input values from the registration form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String contactInfo = request.getParameter("contactInfo");

        // Validate the input values
        if (username == null || username.isEmpty() ||
            password == null || password.isEmpty() ||
            confirmPassword == null || confirmPassword.isEmpty() ||
            email == null || email.isEmpty() ||
            role == null || role.isEmpty() ||
            contactInfo == null || contactInfo.isEmpty()) {

            response.sendRedirect("register.jsp?error=All fields are required.");
            return;
        }

        // Check if password and confirmPassword match
        if (!password.equals(confirmPassword)) {
            response.sendRedirect("register.jsp?error=Passwords do not match.");
            return;
        }

        // Check if the username already exists
        UserDAO userDAO = new UserDAO();
        if (userDAO.getUserByUsername(username) != null) {
            response.sendRedirect("register.jsp?error=Username already exists.");
            return;
        }

        // Create a new user object
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);  // You should hash the password before storing it in production
        newUser.setEmail(email);
        newUser.setRole(role);
        newUser.setContactInfo(contactInfo);

        // Save the user to the database
        boolean isRegistered = userDAO.registerUser(newUser);

        // Check if the registration was successful
        if (isRegistered) {
            response.sendRedirect("login.jsp?success=Registration successful. Please log in.");
        } else {
            response.sendRedirect("register.jsp?error=Registration failed. Please try again.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect GET requests to the registration page
        response.sendRedirect("register.jsp");
    }
}

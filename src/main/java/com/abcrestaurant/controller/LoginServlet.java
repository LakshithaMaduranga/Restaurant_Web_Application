package com.abcrestaurant.controller;

import com.abcrestaurant.dao.UserDAO;
import com.abcrestaurant.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.authenticateUser(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());

            // Redirect based on user role
            if ("Admin".equals(user.getRole())) {
                response.sendRedirect("adminDashboard.jsp");
            } else if ("Staff".equals(user.getRole())) {
                response.sendRedirect("staffDashboard.jsp");
            } else {
                response.sendRedirect("customerDashboard.jsp");
            }
        } else {
            // Authentication failed, redirect back to login page with an error message
            response.sendRedirect("login.jsp?error=Invalid username or password");
        }
    }
}

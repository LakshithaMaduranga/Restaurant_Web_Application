package com.abcrestaurant.controller;

import com.abcrestaurant.dao.LoginDAO;
import com.abcrestaurant.model.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private LoginDAO loginDAO;

    public void init() {
        loginDAO = new LoginDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve the username and password from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Login login = new Login(username, password);

        try {
            if (loginDAO.authenticateUser(login)) {
                // If login is successful, retrieve the user's role
                String role = loginDAO.getUserRole(username);

                // Create a session and store the username and role
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("role", role);

                // Redirect to the appropriate dashboard based on the role
                switch (role) {
                    case "Admin":
                        response.sendRedirect("adminDashboard.jsp");
                        break;
                    case "Staff":
                        response.sendRedirect("staffDashboard.jsp");
                        break;
                    case "Customer":
                        response.sendRedirect("customerDashboard.jsp");
                        break;
                    default:
                        session.invalidate();
                        request.setAttribute("errorMessage", "Invalid user role.");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else {
                // If login fails, set an error message and redirect to login page
                request.setAttribute("errorMessage", "Invalid username or password.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred during login. Please try again.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}

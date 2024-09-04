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
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("user");

        // Check if the user is logged in and is an admin
        if (loggedInUser == null || !loggedInUser.getRole().equals("Admin")) {
            response.sendRedirect("login.jsp?error=Unauthorized access. Please log in as an admin.");
            return;
        }

        String action = request.getParameter("action");

        if (action == null) {
            action = "dashboard";
        }

        switch (action) {
            case "dashboard":
                showDashboard(request, response);
                break;
            case "manageUsers":
                listUsers(request, response);
                break;
            case "editUser":
                showEditForm(request, response);
                break;
            case "deleteUser":
                deleteUser(request, response);
                break;
            default:
                showDashboard(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("user");

        // Check if the user is logged in and is an admin
        if (loggedInUser == null || !loggedInUser.getRole().equals("Admin")) {
            response.sendRedirect("login.jsp?error=Unauthorized access. Please log in as an admin.");
            return;
        }

        String action = request.getParameter("action");

        if (action == null) {
            action = "dashboard";
        }

        switch (action) {
            case "updateUser":
                updateUser(request, response);
                break;
            default:
                showDashboard(request, response);
                break;
        }
    }

    private void showDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userDAO.getAllUsers();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("manageUsers.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        User existingUser = userDAO.getUserById(userID);
        request.setAttribute("user", existingUser);
        request.getRequestDispatcher("editUser.jsp").forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String contactInfo = request.getParameter("contactInfo");

        User user = new User();
        user.setUserID(userID);
        user.setUsername(username);
        user.setEmail(email);
        user.setRole(role);
        user.setContactInfo(contactInfo);

        boolean isUpdated = userDAO.updateUser(user);
        if (isUpdated) {
            response.sendRedirect("admin?action=manageUsers&success=User updated successfully.");
        } else {
            response.sendRedirect("editUser.jsp?userID=" + userID + "&error=Failed to update user. Please try again.");
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        boolean isDeleted = userDAO.deleteUser(userID);
        if (isDeleted) {
            response.sendRedirect("admin?action=manageUsers&success=User deleted successfully.");
        } else {
            response.sendRedirect("admin?action=manageUsers&error=Failed to delete user. Please try again.");
        }
    }
}

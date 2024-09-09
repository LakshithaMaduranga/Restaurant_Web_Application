package com.abcrestaurant.controller;

import com.abcrestaurant.dao.ManageUserDAO;
import com.abcrestaurant.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ManageUserServlet")
public class ManageUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ManageUserDAO manageUserDAO;

    public void init() {
        manageUserDAO = new ManageUserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "update":
                    updateUser(request, response);
                    break;
                case "insert":
                    insertUser(request, response);
                    break;
                default:
                    listUsers(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = manageUserDAO.selectAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("manageUsers.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("user-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        User existingUser = manageUserDAO.selectUser(userID);
        request.setAttribute("user", existingUser);
        request.getRequestDispatcher("user-form.jsp").forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        manageUserDAO.deleteUser(userID);
        response.sendRedirect("ManageUserServlet");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String password = request.getParameter("password");
        String contactInfo = request.getParameter("contactInfo");

        User user = new User(userID, username, email, role, password, contactInfo);
        manageUserDAO.updateUser(user);
        response.sendRedirect("ManageUserServlet");
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String password = request.getParameter("password");
        String contactInfo = request.getParameter("contactInfo");

        User newUser = new User(username, email, role, password, contactInfo);
        manageUserDAO.insertUser(newUser);
        response.sendRedirect("ManageUserServlet");
    }
}

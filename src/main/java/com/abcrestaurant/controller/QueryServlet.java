package com.abcrestaurant.controller;

import com.abcrestaurant.dao.QueryDAO;
import com.abcrestaurant.model.Query;
import com.abcrestaurant.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/query")
public class QueryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private QueryDAO queryDAO;

    public void init() {
        queryDAO = new QueryDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("user");

        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listQueries(request, response);
                break;
            case "new":
                showNewForm(request, response);
                break;
            case "insert":
                insertQuery(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateQuery(request, response);
                break;
            case "delete":
                deleteQuery(request, response);
                break;
            case "respond":
                respondToQuery(request, response);
                break;
            default:
                listQueries(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listQueries(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Query> queryList = queryDAO.getAllQueries();
        request.setAttribute("queryList", queryList);
        request.getRequestDispatcher("manageQueries.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("queryForm.jsp").forward(request, response);
    }

    private void insertQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String customerName = request.getParameter("customerName");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        Query newQuery = new Query(customerName, email, subject, message);
        queryDAO.addQuery(newQuery);
        response.sendRedirect("query?action=list&success=Query submitted successfully.");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int queryID = Integer.parseInt(request.getParameter("queryID"));
        Query existingQuery = queryDAO.getQueryById(queryID);
        request.setAttribute("query", existingQuery);
        request.getRequestDispatcher("queryForm.jsp").forward(request, response);
    }

    private void updateQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int queryID = Integer.parseInt(request.getParameter("queryID"));
        String customerName = request.getParameter("customerName");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        String responseMessage = request.getParameter("response");

        Query query = new Query(queryID, customerName, email, subject, message, responseMessage, "Responded");
        queryDAO.respondToQuery(queryID, responseMessage);
        response.sendRedirect("query?action=list&success=Query updated successfully.");
    }

    private void deleteQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int queryID = Integer.parseInt(request.getParameter("queryID"));
        queryDAO.deleteQuery(queryID);
        response.sendRedirect("query?action=list&success=Query deleted successfully.");
    }

    private void respondToQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int queryID = Integer.parseInt(request.getParameter("queryID"));
        Query query = queryDAO.getQueryById(queryID);
        request.setAttribute("query", query);
        request.getRequestDispatcher("respondToQuery.jsp").forward(request, response);
    }
}

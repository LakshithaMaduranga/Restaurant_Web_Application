package com.abcrestaurant.controller;

import com.abcrestaurant.dao.ReservationDAO;
import com.abcrestaurant.dao.QueryDAO;
import com.abcrestaurant.model.Reservation;
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

@WebServlet("/staff")
public class StaffServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ReservationDAO reservationDAO;
    private QueryDAO queryDAO;

    public void init() {
        reservationDAO = new ReservationDAO();
        queryDAO = new QueryDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("user");

        // Check if the user is logged in and is a staff member
        if (loggedInUser == null || !loggedInUser.getRole().equals("Staff")) {
            response.sendRedirect("login.jsp?error=Unauthorized access. Please log in as a staff member.");
            return;
        }

        String action = request.getParameter("action");

        if (action == null) {
            action = "dashboard";
        }

        switch (action) {
            case "manageReservations":
                listReservations(request, response);
                break;
            case "manageQueries":
                listQueries(request, response);
                break;
            case "respondToQuery":
                showQueryForm(request, response);
                break;
            default:
                response.sendRedirect("staff.jsp");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute("user");

        // Check if the user is logged in and is a staff member
        if (loggedInUser == null || !loggedInUser.getRole().equals("Staff")) {
            response.sendRedirect("login.jsp?error=Unauthorized access. Please log in as a staff member.");
            return;
        }

        String action = request.getParameter("action");

        if (action == null) {
            action = "dashboard";
        }

        switch (action) {
            case "updateReservation":
                updateReservation(request, response);
                break;
            case "respondToQuery":
                respondToQuery(request, response);
                break;
            default:
                response.sendRedirect("staff.jsp");
                break;
        }
    }

    private void listReservations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reservation> reservationList = reservationDAO.getAllReservations();
        request.setAttribute("reservationList", reservationList);
        request.getRequestDispatcher("manageReservations.jsp").forward(request, response);
    }

    private void listQueries(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Query> queryList = queryDAO.getAllQueries();
        request.setAttribute("queryList", queryList);
        request.getRequestDispatcher("manageQueries.jsp").forward(request, response);
    }

    private void showQueryForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int queryID = Integer.parseInt(request.getParameter("queryID"));
        Query query = queryDAO.getQueryById(queryID);
        request.setAttribute("query", query);
        request.getRequestDispatcher("respondToQuery.jsp").forward(request, response);
    }

    private void updateReservation(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int reservationID = Integer.parseInt(request.getParameter("reservationID"));
        String status = request.getParameter("status");

        Reservation reservation = new Reservation();
        reservation.setReservationID(reservationID);
        reservation.setStatus(status);

        boolean isUpdated = reservationDAO.updateReservation(reservation);
        if (isUpdated) {
            response.sendRedirect("staff?action=manageReservations&success=Reservation updated successfully.");
        } else {
            response.sendRedirect("staff?action=manageReservations&error=Failed to update reservation. Please try again.");
        }
    }

    private void respondToQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int queryID = Integer.parseInt(request.getParameter("queryID"));
        String responseMessage = request.getParameter("responseMessage");

        boolean isResponded = queryDAO.respondToQuery(queryID, responseMessage);
        if (isResponded) {
            response.sendRedirect("staff?action=manageQueries&success=Query responded successfully.");
        } else {
            response.sendRedirect("respondToQuery.jsp?queryID=" + queryID + "&error=Failed to respond to query. Please try again.");
        }
    }
}

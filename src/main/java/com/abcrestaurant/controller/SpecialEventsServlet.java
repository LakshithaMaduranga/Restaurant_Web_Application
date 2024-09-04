package com.abcrestaurant.controller;

import com.abcrestaurant.dao.SpecialEventsDAO;
import com.abcrestaurant.model.SpecialEvents;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SpecialEventsServlet")
public class SpecialEventsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SpecialEventsDAO specialEventsDAO;

    public void init() {
        specialEventsDAO = new SpecialEventsDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "insert":
                insertSpecialEvent(request, response);
                break;
            case "delete":
                deleteSpecialEvent(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateSpecialEvent(request, response);
                break;
            default:
                listSpecialEvents(request, response);
                break;
        }
    }

    private void listSpecialEvents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SpecialEvents> events = specialEventsDAO.getAllSpecialEvents();
        request.setAttribute("events", events);
        request.getRequestDispatcher("SpecialEvents.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SpecialEvents newEvent = new SpecialEvents();
        request.setAttribute("event", newEvent);
        request.getRequestDispatcher("SpecialEvents-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int serviceID = Integer.parseInt(request.getParameter("serviceID"));
        SpecialEvents existingEvent = specialEventsDAO.getSpecialEventById(serviceID);
        request.setAttribute("event", existingEvent);
        request.getRequestDispatcher("SpecialEvents-form.jsp").forward(request, response);
    }

    private void insertSpecialEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String serviceName = request.getParameter("serviceName");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String eventDate = request.getParameter("eventDate");
        String eventLocation = request.getParameter("eventLocation");

        SpecialEvents newEvent = new SpecialEvents(0, serviceName, description, price, eventDate, eventLocation);
        specialEventsDAO.addSpecialEvent(newEvent);
        response.sendRedirect("SpecialEventsServlet?action=list");
    }

    private void updateSpecialEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int serviceID = Integer.parseInt(request.getParameter("serviceID"));
        String serviceName = request.getParameter("serviceName");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String eventDate = request.getParameter("eventDate");
        String eventLocation = request.getParameter("eventLocation");

        SpecialEvents event = new SpecialEvents(serviceID, serviceName, description, price, eventDate, eventLocation);
        specialEventsDAO.updateSpecialEvent(event);
        response.sendRedirect("SpecialEventsServlet?action=list");
    }

    private void deleteSpecialEvent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int serviceID = Integer.parseInt(request.getParameter("serviceID"));
        specialEventsDAO.deleteSpecialEvent(serviceID);
        response.sendRedirect("SpecialEventsServlet?action=list");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

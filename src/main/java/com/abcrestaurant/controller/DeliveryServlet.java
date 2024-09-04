package com.abcrestaurant.controller;

import com.abcrestaurant.dao.DeliveryDAO;
import com.abcrestaurant.model.Delivery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DeliveryServlet")
public class DeliveryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DeliveryDAO deliveryDAO;

    public void init() {
        deliveryDAO = new DeliveryDAO();
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
                insertDelivery(request, response);
                break;
            case "delete":
                deleteDelivery(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateDelivery(request, response);
                break;
            default:
                listDeliveries(request, response);
                break;
        }
    }

    private void listDeliveries(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Delivery> deliveries = deliveryDAO.getAllDeliveries();
        request.setAttribute("deliveries", deliveries);
        request.getRequestDispatcher("Delivery.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Delivery newDelivery = new Delivery();
        request.setAttribute("delivery", newDelivery);
        request.getRequestDispatcher("Delivery-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int serviceID = Integer.parseInt(request.getParameter("serviceID"));
        Delivery existingDelivery = deliveryDAO.getDeliveryById(serviceID);
        request.setAttribute("delivery", existingDelivery);
        request.getRequestDispatcher("Delivery-form.jsp").forward(request, response);
    }

    private void insertDelivery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String serviceName = request.getParameter("serviceName");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String deliveryAddress = request.getParameter("deliveryAddress");
        String deliveryTime = request.getParameter("deliveryTime");

        Delivery newDelivery = new Delivery(0, serviceName, description, price, deliveryAddress, deliveryTime);
        deliveryDAO.addDelivery(newDelivery);
        response.sendRedirect("DeliveryServlet?action=list");
    }

    private void updateDelivery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int serviceID = Integer.parseInt(request.getParameter("serviceID"));
        String serviceName = request.getParameter("serviceName");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String deliveryAddress = request.getParameter("deliveryAddress");
        String deliveryTime = request.getParameter("deliveryTime");

        Delivery delivery = new Delivery(serviceID, serviceName, description, price, deliveryAddress, deliveryTime);
        deliveryDAO.updateDelivery(delivery);
        response.sendRedirect("DeliveryServlet?action=list");
    }

    private void deleteDelivery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int serviceID = Integer.parseInt(request.getParameter("serviceID"));
        deliveryDAO.deleteDelivery(serviceID);
        response.sendRedirect("DeliveryServlet?action=list");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

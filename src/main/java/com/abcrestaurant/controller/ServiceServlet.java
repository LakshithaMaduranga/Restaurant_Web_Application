package com.abcrestaurant.controller;

import com.abcrestaurant.dao.ServiceDAO;
import com.abcrestaurant.model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServiceServlet")
public class ServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServiceDAO serviceDAO;

    public void init() {
        serviceDAO = new ServiceDAO();
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
                insertService(request, response);
                break;
            case "delete":
                deleteService(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateService(request, response);
                break;
            default:
                listServices(request, response);
                break;
        }
    }

    private void listServices(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> services = serviceDAO.getAllServices();
        request.setAttribute("services", services);
        request.getRequestDispatcher("service-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("service-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int serviceID = Integer.parseInt(request.getParameter("serviceID"));
        Service existingService = serviceDAO.getServiceById(serviceID);
        request.setAttribute("service", existingService);
        request.getRequestDispatcher("service-form.jsp").forward(request, response);
    }

    private void insertService(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String serviceName = request.getParameter("serviceName");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        Service newService = new Service(0, serviceName, description, price);
        serviceDAO.addService(newService);
        response.sendRedirect("ServiceServlet?action=list");
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int serviceID = Integer.parseInt(request.getParameter("serviceID"));
        String serviceName = request.getParameter("serviceName");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        Service service = new Service(serviceID, serviceName, description, price);
        serviceDAO.updateService(service);
        response.sendRedirect("ServiceServlet?action=list");
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int serviceID = Integer.parseInt(request.getParameter("serviceID"));
        serviceDAO.deleteService(serviceID);
        response.sendRedirect("ServiceServlet?action=list");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

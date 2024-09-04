<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ABC Restaurant - Dine In Services</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">ABC Restaurant</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ServiceServlet?action=list">Services</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="SpecialEventsServlet?action=list">Special Events</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="DineInServlet?action=list">Dine In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="DeliveryServlet?action=list">Delivery</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Dine In Services Section -->
    <div class="container mt-5">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="mb-4">Dine In Services</h2>
                <a href="DineInServlet?action=new" class="btn btn-primary mb-4">Add New Dine In</a>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Service Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Table Number</th>
                            <th>Number of Guests</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dineIn" items="${dineInServices}">
                            <tr>
                                <td>${dineIn.serviceID}</td>
                                <td>${dineIn.serviceName}</td>
                                <td>${dineIn.description}</td>
                                <td>$${dineIn.price}</td>
                                <td>${dineIn.tableNumber}</td>
                                <td>${dineIn.numberOfGuests}</td>
                                <td>
                                    <a href="DineInServlet?action=edit&serviceID=${dineIn.serviceID}" class="btn btn-warning btn-sm">Edit</a>
                                    <a href="DineInServlet?action=delete&serviceID=${dineIn.serviceID}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this dine-in service?');">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

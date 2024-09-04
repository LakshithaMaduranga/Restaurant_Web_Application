<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ABC Restaurant - Special Events</title>
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

    <!-- Special Events Section -->
    <div class="container mt-5">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="mb-4">Special Events</h2>
                <a href="SpecialEventsServlet?action=new" class="btn btn-primary mb-4">Add New Event</a>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Event Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Date</th>
                            <th>Location</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="event" items="${events}">
                            <tr>
                                <td>${event.serviceID}</td>
                                <td>${event.serviceName}</td>
                                <td>${event.description}</td>
                                <td>$${event.price}</td>
                                <td>${event.eventDate}</td>
                                <td>${event.eventLocation}</td>
                                <td>
                                    <a href="SpecialEventsServlet?action=edit&serviceID=${event.serviceID}" class="btn btn-warning btn-sm">Edit</a>
                                    <a href="SpecialEventsServlet?action=delete&serviceID=${event.serviceID}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this event?');">Delete</a>
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

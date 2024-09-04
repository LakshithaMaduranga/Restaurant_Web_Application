<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cancel Reservation - ABC Restaurant</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .form-label {
            font-weight: bold;
        }
        .form-section {
            margin-top: 30px;
        }
        .card-header {
            background-color: #dc3545;
            color: #ffffff;
        }
        footer {
            margin-top: 50px;
            padding: 20px 0;
            background-color: #f8f9fa;
            text-align: center;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">ABC Restaurant - Staff Dashboard</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="staffDashboard.jsp">Dashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="manageReservations.jsp">Manage Reservations</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="respondToQueries.jsp">Respond to Queries</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="manageOrders.jsp">Manage Orders</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link btn btn-danger text-white" href="LogoutServlet">Logout</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Cancel Reservation Section -->
    <div class="container form-section">
        <h1 class="text-center">Cancel Reservation</h1>
        <p class="text-center text-danger">Please review the details below before canceling the reservation.</p>

        <div class="card">
            <div class="card-header">
                Reservation ID: <%= request.getParameter("reservationID") %>
            </div>
            <div class="card-body">
                <!-- Example Details (Replace with dynamic content) -->
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label>Customer Name:</label>
                        <p>John Doe</p>
                    </div>
                    <div class="col-md-6">
                        <label>Email:</label>
                        <p>john.doe@example.com</p>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label>Reservation Date:</label>
                        <p>2024-09-15</p>
                    </div>
                    <div class="col-md-6">
                        <label>Reservation Time:</label>
                        <p>19:00</p>
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label>Number of Guests:</label>
                        <p>4</p>
                    </div>
                    <div class="col-md-6">
                        <label>Special Requests:</label>
                        <p>Vegan meal options.</p>
                    </div>
                </div>

                <!-- Confirm Cancellation Form -->
                <form action="CancelReservationServlet" method="post">
                    <input type="hidden" name="reservationID" value="<%= request.getParameter("reservationID") %>">
                    <div class="text-center">
                        <button type="submit" class="btn btn-danger">Confirm Cancellation</button>
                        <a href="manageReservations.jsp" class="btn btn-secondary">Back to Reservations</a>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 ABC Restaurant. All Rights Reserved.</p>
    </footer>

    <!-- Bootstrap JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

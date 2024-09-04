<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - ABC Restaurant</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="index.jsp">ABC Restaurant</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp#about">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp#gallery">Gallery</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp#services">Services</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp#dinein">Dine-In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp#delivery">Delivery</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp#events">Events</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="register.jsp">Register <span class="sr-only">(current)</span></a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Registration Form -->
    <div class="container mt-5">
        <h2 class="text-center">User Registration</h2>
        <form action="register" method="post" class="mt-4">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="confirmPassword">Confirm Password:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="role">Role:</label>
                <select id="role" name="role" class="form-control">
                    <option value="Customer">Customer</option>
                    <option value="Staff">Staff</option>
                    <option value="Admin">Admin</option>
                </select>
            </div>
            <div class="form-group">
                <label for="contactInfo">Contact Information:</label>
                <textarea id="contactInfo" name="contactInfo" class="form-control" rows="3" required></textarea>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-primary">Register</button>
            </div>
        </form>

        <p class="text-center mt-3">Already have an account? <a href="login.jsp">Login here</a>.</p>

        <!-- Display error message if passwords do not match or other registration errors occur -->
        <%
            String error = request.getParameter("error");
            if (error != null) {
                out.println("<p class='text-danger text-center'>" + error + "</p>");
            }
        %>
    </div>

    <!-- Footer -->
    <footer class="text-muted py-4 bg-light">
        <div class="container">
            <p class="mb-1">© 2024 ABC Restaurant. All rights reserved.</p>
            <ul class="list-inline">
                <li class="list-inline-item"><a href="#">Privacy</a></li>
                <li class="list-inline-item"><a href="#">Terms</a></li>
                <li class="list-inline-item"><a href="#">Contact</a></li>
            </ul>
        </div>
    </footer>

    <!-- Bootstrap JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

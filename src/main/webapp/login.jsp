<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - ABC Restaurant</title>
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
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
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
                <li class="nav-item active">
                    <a class="nav-link" href="login.jsp">Login <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="register.jsp">Register</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Login Form -->
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <h3 class="text-center mb-4">Login to Your Account</h3>
                        <form action="login" method="post">
                            <div class="form-group">
                                <label for="username">Username:</label>
                                <input type="text" id="username" name="username" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" id="password" name="password" class="form-control" required>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary btn-block">Login</button>
                            </div>
                        </form>
                        <div class="text-center mt-3">
                            <p>Don't have an account? <a href="register.jsp">Register here</a>.</p>
                            <p><a href="#">Forgot your password?</a></p>
                        </div>
                        <!-- Display error message if login fails -->
                        <%
                            String error = request.getParameter("error");
                            if (error != null) {
                                out.println("<p class='text-danger text-center mt-3'>" + error + "</p>");
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
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

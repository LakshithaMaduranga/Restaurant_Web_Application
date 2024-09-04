<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ABC Restaurant - Welcome</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
        }
        .navbar {
            background-color: #2c3e50;
        }
        .navbar-brand, .nav-link {
            color: #ecf0f1 !important;
        }
        .navbar-brand {
            font-size: 1.8rem;
            font-weight: bold;
        }
        .navbar-brand span {
            color: #e74c3c;
        }
        .navbar-nav .nav-item .nav-link:hover {
            color: #e74c3c !important;
        }
        .navbar-nav .nav-item + .nav-item {
            margin-left: 15px;
        }
        .hero-section {
            background: url('images/restaurant-banner.jpg') no-repeat center center;
            background-size: cover;
            height: 600px;
            color: white;
            text-align: center;
            display: flex;
            justify-content: center;
            align-items: center;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.7);
        }
        .hero-section h1 {
            font-size: 4rem;
        }
        .section-title {
            text-align: center;
            margin: 50px 0 30px;
            font-size: 2.5rem;
            color: #2c3e50;
        }
        .card {
            transition: transform 0.3s ease-in-out;
            border: none;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .card:hover {
            transform: scale(1.05);
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
        }
        .card-img-top {
            height: 250px;
            object-fit: cover;
        }
        .card-title {
            font-size: 1.5rem;
            color: #e74c3c;
        }
        .gallery-section, .services-section {
            padding: 50px 0;
        }
        .footer {
            background-color: #2c3e50;
            color: white;
            padding: 30px 0;
            text-align: center;
            margin-top: 50px;
        }
        .footer p {
            margin: 0;
            color: #bdc3c7;
        }
        .footer a {
            color: #e74c3c;
            text-decoration: none;
        }
        .footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="#">ABC <span>Restaurant</span></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#services">Services</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#gallery">Gallery</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#contact">Contact</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-primary text-white" href="login.jsp" style="margin-right: 10px;">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-primary text-white" href="register.jsp">Register</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <header class="hero-section">
        <h1>Welcome to ABC Restaurant</h1>
    </header>

    <!-- Gallery Section -->
    <section id="gallery" class="gallery-section">
        <div class="container">
            <h2 class="section-title">Our Gallery</h2>
            <div class="row text-center">
                <div class="col-md-3">
                    <div class="card mb-4">
                        <img src="images/dishes.jpg" class="card-img-top" alt="Dishes">
                        <div class="card-body">
                            <h5 class="card-title">Dishes</h5>
                            <a href="deliveryGallery.jsp?category=dishes" class="btn btn-danger">View Dishes</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card mb-4">
                        <img src="images/offer-dishes.jpg" class="card-img-top" alt="Offer Dishes">
                        <div class="card-body">
                            <h5 class="card-title">Offer Dishes</h5>
                            <a href="deliveryGallery.jsp?category=offer" class="btn btn-danger">View Offers</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card mb-4">
                        <img src="images/favorite-dishes.jpg" class="card-img-top" alt="Favorite Dishes">
                        <div class="card-body">
                            <h5 class="card-title">Favorite Dishes</h5>
                            <a href="deliveryGallery.jsp?category=favorite" class="btn btn-danger">View Favorites</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card mb-4">
                        <img src="images/drinks.jpg" class="card-img-top" alt="Drinks">
                        <div class="card-body">
                            <h5 class="card-title">Drinks</h5>
                            <a href="deliveryGallery.jsp?category=drinks" class="btn btn-danger">View Drinks</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Services Section -->
    <section id="services" class="services-section">
        <div class="container">
            <h2 class="section-title">Our Services</h2>
            <div class="row text-center">
                <div class="col-md-6">
                    <div class="card mb-4">
                        <img src="images/reservation.jpg" class="card-img-top" alt="Reservation">
                        <div class="card-body">
                            <h5 class="card-title">Reservation</h5>
                            <p class="card-text">Book your table online and ensure a great dining experience with us.</p>
                            <a href="reservation.jsp" class="btn btn-danger">Make a Reservation</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card mb-4">
                        <img src="images/delivery.jpg" class="card-img-top" alt="Delivery">
                        <div class="card-body">
                            <h5 class="card-title">Delivery</h5>
                            <p class="card-text">Get your favorite dishes delivered to your doorstep quickly and safely.</p>
                            <a href="delivery.jsp" class="btn btn-danger">Order Delivery</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="footer">
        <p>&copy; 2024 ABC Restaurant. All Rights Reserved.</p>
        <p>1234 Culinary St, Food City, FC 56789 | Phone: (123) 456-7890 | Email: <a href="mailto:info@abcrestaurant.com">info@abcrestaurant.com</a></p>
        <div>
            <a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a>
        </div>
    </footer>

    <!-- Bootstrap JS, Popper.js, and jQuery -->
    
       <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
    

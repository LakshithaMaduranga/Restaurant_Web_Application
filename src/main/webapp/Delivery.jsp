<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delivery - Dishes Gallery</title>
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
                    <a class="nav-link" href="deliveryGallery.jsp">Delivery</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="dineInGallery.jsp">Dine In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="specialEventsGallery.jsp">Special Events</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Sorting and Filtering Section -->
    <div class="container mt-3">
        <form action="deliveryGallery.jsp" method="get" class="form-inline">
            <label for="sort" class="mr-2">Sort by:</label>
            <select name="sort" id="sort" class="form-control mr-2">
                <option value="priceLowToHigh">Price: Low to High</option>
                <option value="priceHighToLow">Price: High to Low</option>
                <option value="offerHighToLow">Offer: High to Low</option>
            </select>
            <button type="submit" class="btn btn-primary">Apply</button>
        </form>
    </div>

    <!-- Dishes Gallery Section -->
    <div class="container mt-4">
        <div class="row">
            <c:forEach var="dish" items="${dishes}">
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <img src="${dish.image}" class="card-img-top" alt="${dish.name}">
                        <div class="card-body">
                            <h5 class="card-title">${dish.name}</h5>
                            <p class="card-text">${dish.description}</p>
                            <p class="card-text"><strong>$${dish.price}</strong></p>
                            <c:if test="${dish.offerPercentage > 0}">
                                <p class="card-text text-danger">${dish.offerPercentage}% OFF</p>
                            </c:if>
                            <a href="addToCartServlet?dishID=${dish.dishID}" class="btn btn-primary">Add to Cart</a>
                            <a href="addToFavoriteServlet?dishID=${dish.dishID}" class="btn btn-secondary">❤</a>
                            <a href="orderServlet?dishID=${dish.dishID}" class="btn btn-success">Order Now</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Bootstrap JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

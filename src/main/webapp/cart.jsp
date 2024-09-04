<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Cart - ABC Restaurant</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="index.jsp">ABC Restaurant</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="deliveryGallery.jsp">Delivery</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="dineInGallery.jsp">Dine In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="specialEventsGallery.jsp">Special Events</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="CartServlet?action=view">Cart</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Cart Content -->
    <div class="container mt-5">
        <h2>Your Cart</h2>
        <c:if test="${empty cart}">
            <p>Your cart is empty.</p>
        </c:if>
        <c:if test="${not empty cart}">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>Dish</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${cart}">
                        <tr>
                            <td><img src="${item.dish.image}" alt="${item.dish.name}" style="width: 100px; height: auto;"></td>
                            <td>${item.dish.name}</td>
                            <td>${item.quantity}</td>
                            <td><fmt:formatNumber value="${item.dish.price}" type="currency" currencySymbol="$"/></td>
                            <td><fmt:formatNumber value="${item.totalPrice}" type="currency" currencySymbol="$"/></td>
                            <td>
                                <a href="CartServlet?action=remove&dishID=${item.dish.dishID}" class="btn btn-danger btn-sm">Remove</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="text-right">
                <a href="checkout.jsp" class="btn btn-success">Proceed to Checkout</a>
            </div>
        </c:if>
    </div>

    <!-- Footer -->
    <footer class="text-center mt-5">
        <p>&copy; 2024 ABC Restaurant. All Rights Reserved.</p>
    </footer>

    <!-- Bootstrap JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

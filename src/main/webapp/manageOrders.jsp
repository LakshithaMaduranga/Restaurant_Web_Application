<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Orders - Admin Dashboard</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .table thead th {
            background-color: #343a40;
            color: #ffffff;
        }
        .btn-primary, .btn-success {
            margin-right: 10px;
        }
        .modal-header {
            background-color: #343a40;
            color: #ffffff;
        }
    </style>
</head>
<body>

    <div class="container mt-5">
        <h1 class="text-center">Manage Orders</h1>
        <p class="text-center">View and manage customer orders.</p>
        
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Customer Name</th>
                    <th>Order Date</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Example Row -->
                <tr>
                    <td>1001</td>
                    <td>John Doe</td>
                    <td>2024-09-15</td>
                    <td>Pending</td>
                    <td>
                        <button class="btn btn-success">Update Status</button>
                        <button class="btn btn-primary">View Details</button>
                    </td>
                </tr>
                <!-- Repeat for each order -->
            </tbody>
        </table>
    </div>

    <!-- Bootstrap JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

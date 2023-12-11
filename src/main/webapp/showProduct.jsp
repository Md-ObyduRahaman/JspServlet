
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css" >
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css" rel="stylesheet">
    <!-- Bootstrap JS -->
    <title>DashBoard</title>
</head>
<body>
<div class="wrapper">

    <jsp:directive.include file="sidebar.jsp" />

    <!-- Page Content  -->
    <div id="content">
        <jsp:directive.include file="navbar.jsp" />

        <div class="container">
            <h2>Product List</h2>
            <table id="table_id" class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <!-- Example table row -->
                <tr>
                    <td>1</td>
                    <td>Product 1</td>
                    <td>Description of Product 1</td>
                    <td>$10.00</td>
                    <td>5</td>
                    <td>
                        <a href="EditProductServlet?id=1" class="btn btn-primary btn-sm">Edit</a>
                        <a href="DeleteProductServlet?id=1" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
                <!-- Add more rows dynamically -->
                </tbody>
            </table>
        </div>

        </div>
</div>

</body>
<!-- Bootstrap JS -->
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>

<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

<script>
    $(document).ready(function () {
        $('#table_id').DataTable();
    });
</script>
</html>

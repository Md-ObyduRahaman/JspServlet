<%@ page import="com.employees.system.model.Product" %>
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
                <%
                    // Retrieve the listUser attribute from the request object
                    java.util.List<Product> productList = (java.util.List<Product>) request.getAttribute("productList");

                    int i=1;
                    // Iterate through the listUser
                    if(productList != null) {
                        for(Product product : productList) {
                %>                <tr>
                    <td><%= i %></td>
                    <%= i=i+1 %>
                    <td><%= product.getProductName() %></td>
                    <td><%= product.getDescription() %></td>
                    <td><%= product.getPrice() %></td>
                    <td><%= product.getQuantity() %></td>

                    <td>
                        <a href="edit?id=<%= product.getId() %>" class="btn btn-primary btn-sm">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<%= product.getId() %>" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
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

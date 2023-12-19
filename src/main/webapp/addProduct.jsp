<%@ page import="com.employees.system.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:directive.include file="style.jsp" />
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

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
            <% if (request.getAttribute("flag") == "saved") { %>
            <p style="color: green;"><%= request.getAttribute("message") %></p>
            <% } else if (request.getAttribute("flag") == "notsaved"){ %>
            <p style="color: red;"><%= request.getAttribute("message") %></p>
            <% } %>
            <h2>Product Submission Form</h2>
            <%
                Product product = (Product) request.getAttribute("product");
                if (product != null) {
            %>
            <form action="update" method="post">
                    <% } else { %>
                        <form action="addProductServlet" method="post">
                        <% } %>
                            <% if (product != null) { %>
                            <input type="hidden" name="id" value="<%= product.getId() %>" />
                            <% } %>

                <div class="form-group">
                    <label for="productName">Product Name:</label>
                    <input type="text" class="form-control" id="productName" name="productName"  value="<%= (product != null) ? product.getProductName() : "" %>" required>
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <textarea class="form-control" id="description" name="description" rows="3"  required>  <%= (product != null) ? product.getDescription() : "" %></textarea>
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" class="form-control" id="price" name="price" step="0.01" value="<%= (product != null) ? product.getPrice() : "" %>" required>
                </div>
                <div class="form-group">
                    <label for="quantity">Quantity:</label>
                    <input type="number" class="form-control" id="quantity" name="quantity" value="<%= (product != null) ? product.getQuantity() : "" %>" required>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

        </div>
</div>

</body>
<!-- Bootstrap JS -->
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</html>

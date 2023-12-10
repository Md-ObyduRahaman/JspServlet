
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css" >
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

        <h1>DashBoard</h1>

        </div>
</div>

</body>
<!-- Bootstrap JS -->
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</html>

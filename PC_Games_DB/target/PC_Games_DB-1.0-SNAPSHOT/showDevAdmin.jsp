<%--
  Created by IntelliJ IDEA.
  User: loay_
  Date: 4/12/2021
  Time: 6:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.PC_Games_DB.dev_admins.devAdmin" %>

<style type="text/css">
    .container {
        display: block;
        margin: 0 auto;
        text-align: center;
    }
</style>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<a href="index.jsp">Sign Out</a>
<div class="container">
    <br>
    <br>
    <%
        devAdmin a = (devAdmin) request.getAttribute("devAdmin");
        out.println("Admin name: " + a.getAdminName());
    %>
    <br>
    <br>

    <%
        out.println("Admin ID: " + a.getAdminId());
    %>
    <br>
    <br>

    <%
        out.println("Email: " + a.getEmail());
    %>
    <br>
    <br>
    <br>

</div>
</body>
</html>

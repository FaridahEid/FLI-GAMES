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
    @import "stylesheet.css";
    .container {
        display: block;
        margin: 0 auto;
        text-align: center;
    }
</style>
<html>
<head>
    <%--Logo in tab--%>
    <link rel = "icon" href ="logo2.png" type = "image/png">
    <title>Admin</title>
</head>
<body>
<a href="index.jsp">Sign Out</a>
<div class="container">
    <br>
    <br>
    <%
        devAdmin a = (devAdmin) request.getAttribute("devAdmin");
        //out.println("Admin name: " + a.getAdminName());
    %>
    <h2>Welcome <%=a.getAdminName()%></h2>

    <%
        //out.println("Admin ID: " + a.getAdminId());
    %>
    <h2>ID: <%=a.getAdminName()%></h2>
    <br>
    <br>

    <%
        //out.println("Email: " + a.getEmail());
    %>
    <h4>Current email <%=a.getEmail()%></h4>
    <br>
    <br>
    <br>

</div>
</body>
</html>

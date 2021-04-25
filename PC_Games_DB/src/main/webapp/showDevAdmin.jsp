<%--
  Created by IntelliJ IDEA.
  User: loay_
  Date: 4/12/2021
  Time: 6:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.PC_Games_DB.dev_admins.DevAdmin" %>

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
    <script>
        function showChangeEmail() {
            document.getElementById("changeEmail").style.display = 'block';
        }

        function showChangePassword() {
            document.getElementById("changePassword").style.display = 'block';
        }
    </script>
</head>
<body>
<a href="index.jsp">Sign Out</a>
<div class="container">
    <br>
    <br>
    <%
        DevAdmin a = (DevAdmin) request.getAttribute("devAdmin");
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
    <h4>Current email: <%=a.getEmail()%></h4>
    <button onclick="showChangeEmail()">Change Email</button>
    <button onclick="showChangePassword()">Change Password</button>
    <br>
    <br>
    <br>
    <form action="getDevAdmin">
        <input type="hidden" name="adminID" value="<%=a.getAdminId()%>">
        <input type="submit" name="showPlayers" value="Show All Players">
    </form>

    <form action="getDevAdmin">
        <input type="hidden" name="adminID" value="<%=a.getAdminId()%>">
        <input type="submit" name="showPublishers" value="Show All Publishers">
    </form>

    <div id="changeEmail" style="display: none">
        <form action="editDevAdmin">
            <input type="hidden" name="adminID" value=<%=a.getAdminId()%>>
            <label>New Email: </label>
            <input type="email" name="email">
            <input type="submit" name="changeEmail" value="Change">
        </form>

    </div>

    <div id="changePassword" style="display: none">
        <form action="editDevAdmin">
            <input type="hidden" name="adminID" value=<%=a.getAdminId()%>>
            <label>Old Password: </label>
            <input type="password" name="oldPassword">
            <br>
            <label>New Password: </label>
            <input type="password" name="newPassword">
            <label>Password must be at least 8 characters.</label>
            <br>
            <input type="submit" name="changePassword" value="Change">
        </form>
    </div>

</div>
</body>
</html>

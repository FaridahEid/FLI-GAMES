<%--
  Created by IntelliJ IDEA.
  User: loay_
  Date: 4/12/2021
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.PC_Games_DB.publishers.publisher" %>
<%@ page import="com.PC_Games_DB.errors.publisherError" %>
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
    <title>Publisher</title>
    <script type="text/javascript">
        function showChangePassword(){
            document.getElementById('changePassword').style.display = 'block'
        }
    </script>
</head>
<body>
<a href="index.jsp">Sign Out</a>
<div class="container">
    <br>
    <br>
    <%
        publisherError error = (publisherError) request.getAttribute("error");
        if(error!=null){
            if(error.isOldPasswordError()){

    %>
    <p style="color: red">Old Password is Incorrect. Try again.</p>
    <br>
    <br>
    <%
            }else if(error.isNewPasswordError()){

    %>
    <p style="color: red">New Password does not meet requirements. Try again.</p>
    <br>
    <br>

    <%
            }
        }
        publisher p = (publisher) request.getAttribute("publisher");
        out.println("Publisher name: " + p.getPname());
    %>
    <br>
    <br>

    <%
        out.println("Publisher ID: " + p.getPublisherID());
    %>
    <br>
    <br>
    <input type="button" onclick="showChangePassword()" value="Change Password">

    </form>
    <br>
    <br>
    <form action="getPublisher">
        <input type="hidden" name="publisherID" value=<%=p.getPublisherID()%>>
        <input type="submit" name="games" value="Show Current Games">
        <br>
        <br>
    </form>
    <br>
    <br>
    <div id="changePassword" style="display: none">
        <form action="editPublisher">
            <input type="hidden" name="publisherID" value=<%=p.getPublisherID()%>>
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
    <form action="editPublisher">
</div>
</body>
</html>

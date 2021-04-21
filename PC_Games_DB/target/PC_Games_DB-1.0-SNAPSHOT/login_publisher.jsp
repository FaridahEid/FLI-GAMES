<%@ page import="com.PC_Games_DB.errors.publisherError" %><%--
  Created by IntelliJ IDEA.
  User: loay_
  Date: 4/12/2021
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Publisher Log in</title>
</head>
<body>
<div class="container card">
    <br>
    <h2>Login as a Publisher</h2>
    <%
        publisherError error = (publisherError) request.getAttribute("error");
        if(error!=null){
            if(error.isLoginError()){


    %>
    <br>
    <p style="color: red">Invalid Credentials. Try again.</p>
    <br>
    <%
            }
        }
    %>
    <form action="getPublisher">
        <label>Publisher ID</label>
        <input type="text" name ="publisherID">
        <br>
        <br>
        <label>Password</label>
        <input type="password" name ="password">
        <br>
        <br>
        <input type="submit" name="login" value="Log in">
    </form>
    <br>
    <br>

</div>
</body>
</html>

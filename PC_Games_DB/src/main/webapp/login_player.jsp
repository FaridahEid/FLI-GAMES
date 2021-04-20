
<%@ page import="com.PC_Games_DB.errors.playerEditProfileError" %><%--
  Created by IntelliJ IDEA.
  User: loay_
  Date: 4/12/2021
  Time: 9:36 AM
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
    <title>Player Log in</title>
</head>
<body>
<div class="container card">
    <br>
    <h2>Login as a Player</h2>
    <%
        playerEditProfileError error = (playerEditProfileError) request.getAttribute("error");
        if(error!=null){
            if(error.isOldPasswordError()){

    %>
    <p style="color: red">Invalid Credentials. Try again.</p>
    <br>
    <br>
    <%
            }
        }
    %>
    <form action="getPlayer">
        <label>Player ID</label>
        <input type="text" name ="gamerID">
        <br>
        <br>
        <label>Password</label>
        <input type="password" name ="password">
        <input type="hidden" name="link" value="main">
        <br>
        <br>
        <input type="submit" name="login" value="Log in">
    </form>
    <br>
    <br>
    <a href="signup_player.jsp">Sign up</a>
</div>
<script>
    function myFunction() {
        var element = document.body;
        element.classList.toggle("dark-mode");
    }
</script>
</body>
</html>

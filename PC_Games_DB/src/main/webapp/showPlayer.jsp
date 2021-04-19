<%--
  Created by IntelliJ IDEA.
  User: loay_
  Date: 4/12/2021
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.PC_Games_DB.players.player" %>
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
    <title>Player</title>
</head>
<body>
<a href="index.jsp">Sign Out</a>
<div class="container">
    <br>
    <br>
    <%
        player p = (player) request.getAttribute("player");
        //out.println("Welcome " + p.getGamerName() + "!");
    %>
    <h2>Welcome <%=p.getGamerName()%></h2>

    <br>
    <br>
    <form action="getPlayer">
        <input type="hidden" name="gamerID" value=<%=p.getGamerID()%>>
        <input type="submit" name="profile" value="Show Profile">
        <br>
        <br>
        <input type="submit" name="games" value="Show Current Games">
        <br>
        <br>
    </form>


</div>
</body>
</html>

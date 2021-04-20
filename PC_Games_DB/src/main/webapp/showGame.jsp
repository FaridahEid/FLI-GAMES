<%@ page import="com.PC_Games_DB.games.game" %><%--
  Created by IntelliJ IDEA.
  User: loay_
  Date: 4/10/2021
  Time: 3:04 PM
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
    <title>Game</title>
</head>
<body>
<div class="container">
    <%
        game g1 = (game)request.getAttribute("game");
        System.out.println(g1);
        String str = "ID: " + g1.getGameID() + "\nname: " + g1.getGname() + "\nyear: " + g1.getYear() + "\ngenre: " + g1.getGenre()
                + "\ndownloads: " + g1.getDownloads();
        out.println( "ID: " + g1.getGameID());%>
    <br>
    <%
        out.println( "name: " + g1.getGname());%>
    <br>
    <%
        out.println( "year: " + g1.getYear());%>
    <br>
    <%
        out.println( "genre: " + g1.getGenre());%>
    <br>
    <%
        out.println( "downloads: " + g1.getDownloads());%>
    <br>

</div>
</body>
</html>

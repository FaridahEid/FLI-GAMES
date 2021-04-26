<%@ page import="com.PC_Games_DB.games.Game" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.PC_Games_DB.players.player" %><%--
  Created by IntelliJ IDEA.
  User: loay_
  Date: 4/16/2021
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    @import "stylesheet.css";


    .container {
        display: block;
        margin: 0 auto;
        text-align: center;
        color:white;
    }

    table, th, td {
        border: 1px solid #a9dad5;
        border-collapse: collapse;
    }
    th, td {
        padding: 15px;
    }
    table {
        border-spacing: 5px;
    }
    th {
        text-align: left;
    }
    .center {
        margin-left: auto;
        margin-right: auto;
    }
</style>
<html>
<head>
    <%--Logo in tab--%>
    <link rel = "icon" href ="logo2.png" type = "image/png">
    <title>Players</title>
</head>
<body>
<a href="index.jsp">Sign Out</a>
<div class="container">
    <br>
    <br>
    <h2>
        <%
            Game g = (Game) request.getAttribute("game");
            ArrayList<player> players = (ArrayList<player>) request.getAttribute("players");
            out.println("All Players for GameID: " + g.getGameID());
        %>
    </h2>
    <br>
    <br>
    <table style="width:31.5%" class="center">
        <tr class="boxed2">
            <th>Gamer ID</th>
            <th>Gamer Name</th>
            <th>Email</th>
        </tr>
        <%
            for(player p: players){


        %>
        <tr>
            <td><w><%=p.getGamerID()%></w></td>
            <td><w><%=p.getGamerName()%></w></td>
            <td><w><%=p.getEmail()%></w></td>
        </tr>
        <%
            }
        %>
</div>
</body>
</html>

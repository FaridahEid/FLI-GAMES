<%@ page import="com.PC_Games_DB.games.game" %>
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
    .container {
        display: block;
        margin: 0 auto;
        text-align: center;
    }
    table, th, td {
        border: 1px solid black;
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
    <title>Players</title>
</head>
<body>
<a href="index.jsp">Sign Out</a>
<div class="container">
    <br>
    <br>
    <h2>
        <%
            game g = (game) request.getAttribute("game");
            ArrayList<player> players = (ArrayList<player>) request.getAttribute("players");
            out.println("All Players for GameID: " + g.getGameID());
        %>
    </h2>
    <br>
    <br>
    <table style="width:60%" class="center">
        <tr>
            <th>Gamer ID</th>
            <th>Gamer Name</th>
            <th>Email</th>
        </tr>
        <%
            for(player p: players){


        %>
        <tr>
            <td><%=p.getGamerID()%></td>
            <td><%=p.getGamerName()%></td>
            <td><%=p.getEmail()%></td>
        </tr>
        <%
            }
        %>
</div>
</body>
</html>

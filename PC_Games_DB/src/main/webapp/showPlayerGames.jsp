<%--
  Created by IntelliJ IDEA.
  User: loay_
  Date: 4/12/2021
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.PC_Games_DB.games.game" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.PC_Games_DB.players.player" %>
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
    <title>Games</title>
</head>
<body>
<a href="index.jsp">Sign Out</a>
<div class="container">
    <br>
    <br>
    <%
        player p = (player) request.getAttribute("player");
    %>
    <form action="getGame">
        <input type="hidden" name="gamerID" value =<%=p.getGamerID()%>>
        <input type="submit" name="gamesListPlayer" value="Add more games to your list?">
    </form>
    <br>
    <br>
    <h2>Your Current Games</h2>
    <br>
    <br>
    <%
        ArrayList<game> games = (ArrayList<game>) request.getAttribute("games");
        if(games.isEmpty()){

    %>
    <p style="color: red">Your Games List is Empty.</p>
    <%
        }else{
    %>
</div>
</body>

<div class="container">

    <%----%>
    <table class="center">
        <tr class="boxed2">
            <th><b>Name</b></th>
            <th><b>Year</b></th>
            <th><b>Genre</b></th>
            <th><b>Distribution Services</b></th>
        </tr>
    <%

        for(game g: games){


            %>
        <tr>
            <td><w><%=g.getGname()%></w></td>
            <td><w><%=g.getYear()%></w></td>
            <td><w><%=g.getGenre()%></w></td>
            <td><w><%for(String s: g.getPlatform()){
                out.println(s);
                %>
                <br>
                <%
            }%>
            </w></td>
        </tr>
    <%
        }
        }
    %>
    </table>
</div>

</html>

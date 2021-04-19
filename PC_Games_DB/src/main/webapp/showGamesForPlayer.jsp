<%--
  Created by IntelliJ IDEA.
  User: loay_
  Date: 4/15/2021
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.PC_Games_DB.games.game" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.PC_Games_DB.players.player" %>
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
    <title>Games</title>
</head>
<body>
<a href="index.jsp">Sign Out</a>
<div class="container">
    <%
        player p = (player) request.getAttribute("player");
        ArrayList<game> games = (ArrayList<game>) request.getAttribute("games");
    %>
    <br>
    <br>
    <form action="getGame">
        <p>Order by:  </p>
        <input type="hidden" name="gamerID" value =<%=p.getGamerID()%>>
        <input type="submit" name="gamesListPlayerNamesAsc" value="Name Ascending">
        <input type="submit" name="gamesListPlayerNamesDesc" value="Name Descending">
        <input type="submit" name="gamesListPlayerYearsAsc" value="Year Ascending">
        <input type="submit" name="gamesListPlayerYearsDesc" value="Year Descending">
    </form>
    <br>
    <form action="getGame">
        <p>Search by:  </p>
        <input type="hidden" name="gamerID" value =<%=p.getGamerID()%>>
        <label>Game Name: </label>
        <input type="text" name="name">
        <input type="submit" name="gamesListPlayerSearchName" value="Search">
        <br>
        <label>Year: </label>
        <input type="text" name="year">
        <input type="submit" name="gamesListPlayerSearchYear" value="Search">
        <label> (e.g. 2020)</label>
        <br>
        <label>Genre: </label>
        <input type="text" name="genre">
        <input type="submit" name="gamesListPlayerSearchGenre" value="Search">
        <label> (e.g. Puzzle)</label>
        <br>
        <label>Distribution Service: </label>
        <input type="text" name="platform">
        <input type="submit" name="gamesListPlayerSearchPlatform" value="Search">
        <label> (e.g. Steam)</label>
    </form>
    <br>
    <br>
    <%
        if(games.isEmpty()){

        %>
    <h1>No Games Found.</h1>
    <%

        }else{
    %>
    <table style="width:60%" class="center">
        <tr>
            <th>Name</th>
            <th>Year</th>
            <th>Genre</th>
            <th>Distribution Services</th>
            <th>Add</th>
        </tr>
        <%
            for(game g: games){
        %>
        <tr>
            <td><%=g.getGname()%></td>
            <td><%=g.getYear()%></td>
            <td><%=g.getGenre()%></td>
            <td><%for(String s: g.getPlatform()){
                out.println(s);
            %>
                <br>
                <%
                    }%>
            </td>
            <td>
                <form action="addGame">
                    <input type="hidden" name="gameID" value=<%=g.getGameID()%>>
                    <input type="hidden" name="gamerID" value=<%=p.getGamerID()%>>
                    <input type="submit" name="addGame" value="Add Game">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        }
    %>
</div>
</body>
</html>

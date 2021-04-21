<%--
  Created by IntelliJ IDEA.
  User: loay_
  Date: 4/15/2021
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.PC_Games_DB.games.Game" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.PC_Games_DB.players.player" %>
<style type="text/css">
    @import "stylesheet.css";
    <%--
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
    --%>
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
    <%
        player p = (player) request.getAttribute("player");
        ArrayList<Game> games = (ArrayList<Game>) request.getAttribute("games");
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
        <tr class="boxed2">
            <th><b>Name</b></th>
            <th><b>Year</b></th>
            <th><b>Genre</b></th>
            <th><b>Distribution Services</b></th>
            <th><b>Add</b></th>
        </tr>
        <%
            for(Game g: games){
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


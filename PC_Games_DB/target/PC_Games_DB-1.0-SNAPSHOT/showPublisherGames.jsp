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
<%@ page import="com.PC_Games_DB.publishers.publisher" %>
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
    <br>
    <br>
    <h2>Your Current Games</h2>
    <%
        publisher p = (publisher) request.getAttribute("publisher");
    %>
    <br>
    <br>
    <table style="width:60%" class="center">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Year</th>
            <th>Genre</th>
            <th>Developer</th>
            <th>Downloads</th>
            <th>Distribution Services</th>
            <th>Players</th>
        </tr>
    <%
        ArrayList<game> games = (ArrayList<game>) request.getAttribute("games");
        for(game g: games){
            //String str = "Game Name: " + g.getGname() + ", Year: " + g.getYear() + ", Genre: " + g.getGenre();
            //out.println(str);

            %>
        <tr>
            <td><%=g.getGameID()%></td>
            <td><%=g.getGname()%></td>
            <td><%=g.getYear()%></td>
            <td><%=g.getGenre()%></td>
            <td><%=g.getDeveloper()%></td>
            <td><%=g.getDownloads()%></td>
            <td><%for(String s: g.getPlatform()){
                out.println(s);
            %>
                <br>
                <%
                    }%>
            </td>
            <td>
                <form action="getPublisher">
                    <input type="hidden" name="publisherID" value=<%=p.getPublisherID()%>>
                    <input type="hidden" name="gameID" value=<%=g.getGameID()%>>
                    <input type="submit" name="showPlayers" value="Show Active Players">
                </form>
            </td>
        </tr>
    <%
        }
    %>
</div>
</body>
</html>

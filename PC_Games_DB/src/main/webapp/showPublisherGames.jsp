<%--
  Created by IntelliJ IDEA.
  User: loay_
  Date: 4/12/2021
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.PC_Games_DB.games.Game" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.PC_Games_DB.publishers.publisher" %>
<style type="text/css">
    @import "stylesheet.css";
    <%--.container {
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
    <br>
    <br>
    <h2>Your Current Games</h2>
    <%
        publisher p = (publisher) request.getAttribute("publisher");
    %>
    <br>
    <br>
    <table style="width:70%" class="center">
        <tr class="boxed2">
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
        ArrayList<Game> games = (ArrayList<Game>) request.getAttribute("games");
        for(Game g: games){
            //String str = "Game Name: " + g.getGname() + ", Year: " + g.getYear() + ", Genre: " + g.getGenre();
            //out.println(str);

            %>
        <tr>
            <td><w><%=g.getGameID()%></w></td>
            <td><w><%=g.getGname()%></w></td>
            <td><w><%=g.getYear()%></w></td>
            <td><w><%=g.getGenre()%></w></td>
            <td><w><%=g.getDeveloper()%></w></td>
            <td><w><%=g.getDownloads()%></w></td>
            <td><w><%for(String s: g.getPlatform()){
                out.println(s);
            %>
                <br>
                <%
                    }%>
            </w></td>
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

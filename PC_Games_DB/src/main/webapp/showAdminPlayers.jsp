<%@ page import="com.PC_Games_DB.dev_admins.DevAdmin" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.PC_Games_DB.players.player" %><%--
  Created by IntelliJ IDEA.
  User: loay_
  Date: 4/24/2021
  Time: 9:31 AM
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
  <%
    DevAdmin a = (DevAdmin) request.getAttribute("admin");


  %>
  <br>
  <br>
  <form action="getDevAdmin">
    <label>Search by Gamer ID: </label>
    <input type="hidden" name="adminID" value=<%=a.getAdminId()%>>
    <input type="text" name="gamerID">
    <input type="submit" name="searchByGamerID" value="Search">
  </form>
  <br>
  <br>
  <%
    ArrayList<player> players = (ArrayList<player>) request.getAttribute("players");
    if(players.isEmpty()){


  %>
  <h1>No Players Found.</h1>
  <%
    }else{

  %>
  <table style="width:44%" class="center" >
    <tr class="boxed2">
      <th><b>Player ID</b></th>
      <th><b>Player Name</b></th>
      <th><b>Email</b></th>
      <th><b>Date Joined</b></th>
      <th><b>Remove Player</b></th>
    </tr>
    <%
      for(player p: players){
    %>
    <tr>
      <td><w><%=p.getGamerID()%></w></td>
      <td><w><%=p.getGamerName()%></w></td>
      <td><w><%=p.getEmail()%></w></td>
      <td><w><%=p.getDate_joined()%></w></td>
      <td><w>
        <form action="getDevAdmin">
          <input type="hidden" name="adminID" value=<%=a.getAdminId()%>>
          <input type="hidden" name="gamerID" value=<%=p.getGamerID()%>>
          <input type="submit" name="removePlayer" value="Remove Player Account">
        </form>
      </w>
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

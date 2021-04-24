<%@ page import="com.PC_Games_DB.dev_admins.devAdmin" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.PC_Games_DB.publishers.publisher" %><%--
  Created by IntelliJ IDEA.
  User: loay_
  Date: 4/24/2021
  Time: 10:38 AM
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

  <link rel = "icon" href ="logo2.png" type = "image/png">
  <title>Publishers</title>
</head>
<body>
<a href="index.jsp">Sign Out</a>
<div class="container">
  <br>
  <br>
  <%
    devAdmin a = (devAdmin) request.getAttribute("admin");
    ArrayList<publisher> publishers = (ArrayList<publisher>) request.getAttribute("publishers");

  %>
  <form action="getDevAdmin">
    <label>Search by Gamer ID: </label>
    <input type="hidden" name="adminID" value=<%=a.getAdminId()%>>
    <input type="text" name="publisherID">
    <input type="submit" name="searchByPublisherID" value="Search">
  </form>

  <%
    if (publishers.isEmpty()) {

  %>
  <h1>No Players Found.</h1>
  <%
    }else{

  %>
  <table style="width:20%" class="center">
    <tr class="boxed2">
      <th><b>Publisher ID</b></th>
      <th><b>Publisher Name</b></th>
    </tr>
      <%
      for(publisher p: publishers){

    %>
    <tr>
      <td><w><%=p.getPublisherID()%></w></td>
      <td><w><%=p.getPname()%></w></td>
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

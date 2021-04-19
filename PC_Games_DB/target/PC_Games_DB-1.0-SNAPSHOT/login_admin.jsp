<%--
  Created by IntelliJ IDEA.
  User: loay_
  Date: 4/12/2021
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    .container {
        display: block;
        margin: 0 auto;
        text-align: center;
    }
</style>

<html>
<head>
    <title>Admin Login</title>
</head>
<body>
<div class="container">
    <br>
    <h2>Login as an Admin</h2>
    <form action="getDevAdmin">
        <label>Admin ID</label>
        <input type="text" name ="adminID">
        <br>
        <br>
        <label>Password</label>
        <input type="password" name ="password">
        <br>
        <br>
        <input type="submit" name="login" value="Log in">
    </form>
    <br>
    <br>

</div>
</body>
</html>

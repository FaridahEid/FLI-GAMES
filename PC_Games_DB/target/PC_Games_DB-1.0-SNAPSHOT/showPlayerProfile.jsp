<%--
  Created by IntelliJ IDEA.
  User: loay_
  Date: 4/12/2021
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.PC_Games_DB.players.player" %>
<%@ page import="com.PC_Games_DB.errors.playerEditProfileError" %>
<style type="text/css">
    @import "stylesheet.css";
    .container {
        display: block;
        font-size: 20px;
        margin: 10px 20px 10px 30px;
        /*text-align: center;*/
    }
</style>
<html>
<head>
    <%--Logo in tab--%>
    <link rel = "icon" href ="logo2.png" type = "image/png">
    <title>Player Profile</title>
    <script type="text/javascript">
        function showChangeName(){
            document.getElementById('changeName').style.display = 'block'
        }
        function showChangePassword(){
            document.getElementById('changePassword').style.display = 'block'
        }
        function showChangeEmail(){
            document.getElementById('changeEmail').style.display = 'block'
        }
    </script>
</head>
<body class="container messagebox">
<a href="index.jsp">Sign Out</a>
<div>
    <br>
    <br>
    <%
        playerEditProfileError error = (playerEditProfileError) request.getAttribute("error");
        if(error!=null){
            if(error.isOldPasswordError()){

    %>
    <p style="color: red">Old Password is Incorrect. Try again.</p>
    <br>
    <br>
    <%
        }else if(error.isNewPasswordError()){

    %>
    <p style="color: red">New Password does not meet requirements. Try again.</p>
    <br>
    <br>
    <%
            }
        }
        player p = (player) request.getAttribute("player");
        //out.println("Gamer name:"  + p.getGamerName());

    %>
    <div class="boxed gn">Gamer name: <%=p.getGamerName()%>
        <%--style="float: right;"--%>
        <input type="button" class="myButton" value="Level 4" style="float: right;">
    </div>

        <%
            //out.println("Gamer ID: " + p.getGamerID());
        %>
    <br>
    <div class="pp"></div>
        <h4>Gamer ID: <%=p.getGamerID()%></h4>
        <%
            //out.println("Date of birth: " + p.getDOB());
        %>
    <br>
        <h4>Date of Birth: <%=p.getDOB()%></h4>
        <%
            //out.println("Email: " + p.getEmail());
        %>
        <h4>Email: <%=p.getEmail()%></h4>
        <%
            //out.println("Date joined: " + p.getDate_joined());
        %>
        <h4>Date joined: <%=p.getDate_joined()%></h4>

    <br>
    <br>
    <br>
    <%--class="myButton"--%>
    <input type="button" onclick="showChangeName()" value="Change Gamer Name">
    <input type="button" onclick="showChangeEmail()" value="Change Email">
    <input type="button" onclick="showChangePassword()" value="Change Password">
    <br>
    <br>
    <div id="changeName" style="display: none">
        <form action="editPlayer">
            <input type="hidden" name="gamerID" value=<%=p.getGamerID()%>>
            <label>New Gamer Name: </label>
            <input type="text" name="gamerName">
            <input type="submit" name="changeGamerName" value="Change">
        </form>
    </div>
    <div id="changeEmail" style="display: none">
        <form action="editPlayer">
            <input type="hidden" name="gamerID" value=<%=p.getGamerID()%>>
            <label>New Email: </label>
            <input type="email" name="email">
            <input type="submit" name="changeEmail" value="Change">
        </form>
    </div>
    <div id="changePassword" style="display: none">
        <form action="editPlayer">
            <input type="hidden" name="gamerID" value=<%=p.getGamerID()%>>
            <label>Old Password: </label>
            <input type="password" name="oldPassword">
            <br>
            <label>New Password: </label>
            <input type="password" name="newPassword">
            <label>Password must be at least 8 characters.</label>
            <br>
            <input type="submit" name="changePassword" value="Change">
        </form>
    </div>



</div>
</body>
</html>

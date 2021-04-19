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
        margin: 0 auto;
        text-align: center;
    }
</style>
<html>
<head>
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
<body>
<a href="index.jsp">Sign Out</a>
<div class="container">
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
    <div class="sticky"> Gamer name: <%=p.getGamerName()%></div>

    <%
        //out.println("Gamer ID: " + p.getGamerID());
    %>
    <h4>Gamer ID: <%=p.getGamerID()%></h4>

    <%
        //out.println("Date of birth: " + p.getDOB());
    %>
    <h5>Date of Birth: <%=p.getDOB()%></h5>
    <%
        //out.println("Email: " + p.getEmail());
    %>
    <h5>Email: <%=p.getEmail()%></h5>
    <%
        //out.println("Date joined: " + p.getDate_joined());
    %>
    <h5>Date joined: <%=p.getDate_joined()%></h5>
    <br>
    <br>
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

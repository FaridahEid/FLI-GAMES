package com.PC_Games_DB;

import com.PC_Games_DB.errors.playerEditProfileError;
import com.PC_Games_DB.players.dao.playerDao;
import com.PC_Games_DB.players.player;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "editPlayer", value = "/editPlayer")
public class editPlayer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gamerID = request.getParameter("gamerID");
        if(request.getParameter("changeGamerName")!=null){
            String name = request.getParameter("gamerName");
            playerDao dao = new playerDao();
            player p = dao.getPlayer(gamerID);
            boolean x = dao.changeName(gamerID,name);
            request.setAttribute("player",p);
            RequestDispatcher rd =request.getRequestDispatcher("showPlayerProfile.jsp");
            rd.forward(request,response);
        }
        if(request.getParameter("changeEmail")!=null){
            String email = request.getParameter("email");
            playerDao dao = new playerDao();
            player p = dao.getPlayer(gamerID);
            boolean x = dao.changeEmail(gamerID,email);
            request.setAttribute("player",p);
            RequestDispatcher rd =request.getRequestDispatcher("showPlayerProfile.jsp");
            rd.forward(request,response);
        }
        if(request.getParameter("changePassword")!=null){
            playerDao dao = new playerDao();
            player p = dao.getPlayer(gamerID);
            String oldPassword = request.getParameter("oldPassword");
            if(dao.checkPassword(gamerID,oldPassword)){
                String newPassword = request.getParameter("newPassword");
                if(newPassword.length()>7){
                    boolean x = dao.changePassword(gamerID,newPassword);
                    request.setAttribute("player",p);
                    RequestDispatcher rd =request.getRequestDispatcher("showPlayerProfile.jsp");
                    rd.forward(request,response);
                }else{
                    playerEditProfileError error = new playerEditProfileError();
                    error.setOldPasswordError(false);
                    error.setNewPasswordError(true);
                    request.setAttribute("error",error);
                    request.setAttribute("player",p);
                    RequestDispatcher rd =request.getRequestDispatcher("showPlayerProfile.jsp");
                    rd.forward(request,response);
                }
            }else{
                playerEditProfileError error = new playerEditProfileError();
                error.setOldPasswordError(true);
                error.setNewPasswordError(false);
                request.setAttribute("error",error);
                request.setAttribute("player",p);
                RequestDispatcher rd =request.getRequestDispatcher("showPlayerProfile.jsp");
                rd.forward(request,response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

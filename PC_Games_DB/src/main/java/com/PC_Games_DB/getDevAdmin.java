package com.PC_Games_DB;


import com.PC_Games_DB.errors.PlayerEditProfileError;
import com.PC_Games_DB.players.player;
import com.PC_Games_DB.publishers.publisher;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

import com.PC_Games_DB.dev_admins.dao.DevAdminDao;
import com.PC_Games_DB.dev_admins.DevAdmin;

@WebServlet(name = "getDevAdmin", value = "/getDevAdmin")
public class getDevAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("login")!=null){
            String adminID = request.getParameter("adminID");
            String password = request.getParameter("password");
            DevAdminDao dao = new DevAdminDao();
            DevAdmin d = dao.devAdminSignin(adminID,password);
            if(d!=null){
                request.setAttribute("devAdmin",d);
                RequestDispatcher rd = request.getRequestDispatcher("showDevAdmin.jsp");
                rd.forward(request,response);
            }else{
                PlayerEditProfileError error = new PlayerEditProfileError();
                error.setOldPasswordError(true);
                error.setNewPasswordError(false);
                request.setAttribute("error", error);
                RequestDispatcher rd = request.getRequestDispatcher("login_admin.jsp");
                rd.forward(request, response);
            }
        }
        if(request.getParameter("showPlayers")!=null){
            String adminID = request.getParameter("adminID");
            DevAdminDao dao = new DevAdminDao();
            DevAdmin a = dao.getDevAdmin(adminID);
            ArrayList<player> players = dao.getAllPlayers();
            request.setAttribute("players",players);
            request.setAttribute("admin",a);
            RequestDispatcher rd = request.getRequestDispatcher("showAdminPlayers.jsp");
            rd.forward(request,response);
        }
        if(request.getParameter("searchByGamerID")!=null){
            String adminID = request.getParameter("adminID");
            String gamerID = request.getParameter("gamerID");
            DevAdminDao dao = new DevAdminDao();
            DevAdmin a = dao.getDevAdmin(adminID);
            ArrayList<player> players = dao.getPlayersByGamerID(gamerID);
            request.setAttribute("players",players);
            request.setAttribute("admin",a);
            RequestDispatcher rd = request.getRequestDispatcher("showAdminPlayers.jsp");
            rd.forward(request,response);
        }
        if(request.getParameter("removePlayer")!=null){
            String adminID = request.getParameter("adminID");
            String gamerID = request.getParameter("gamerID");
            DevAdminDao dao = new DevAdminDao();
            DevAdmin a = dao.getDevAdmin(adminID);
            boolean x = dao.deletePlayer(gamerID);
            ArrayList<player> players = dao.getAllPlayers();
            request.setAttribute("players",players);
            request.setAttribute("admin",a);
            RequestDispatcher rd = request.getRequestDispatcher("showAdminPlayers.jsp");
            rd.forward(request,response);
        }
        if(request.getParameter("showPublishers")!=null){
            String adminID = request.getParameter("adminID");
            DevAdminDao dao = new DevAdminDao();
            DevAdmin a = dao.getDevAdmin(adminID);
            ArrayList<publisher> publishers = dao.getAllPublishers();
            request.setAttribute("publishers",publishers);
            request.setAttribute("admin",a);
            RequestDispatcher rd = request.getRequestDispatcher("showAdminPublishers.jsp");
            rd.forward(request,response);
        }
        if(request.getParameter("searchByPublisherID")!=null){
            String adminID = request.getParameter("adminID");
            String publisherID = request.getParameter("publisherID");
            DevAdminDao dao = new DevAdminDao();
            DevAdmin a = dao.getDevAdmin(adminID);
            ArrayList<publisher> publishers = dao.getPublisherByID(publisherID);
            request.setAttribute("publishers",publishers);
            request.setAttribute("admin",a);
            RequestDispatcher rd = request.getRequestDispatcher("showAdminPublishers.jsp");
            rd.forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

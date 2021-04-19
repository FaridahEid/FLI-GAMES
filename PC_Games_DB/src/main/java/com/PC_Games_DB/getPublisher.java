package com.PC_Games_DB;

import com.PC_Games_DB.errors.publisherError;
import com.PC_Games_DB.games.dao.gameDao;
import com.PC_Games_DB.games.game;
import com.PC_Games_DB.players.dao.playerDao;
import com.PC_Games_DB.players.player;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

import com.PC_Games_DB.publishers.publisher;
import com.PC_Games_DB.publishers.dao.publisherDao;

@WebServlet(name = "getPublisher", value = "/getPublisher")
public class getPublisher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("login")!=null){
            String publisherID = request.getParameter("publisherID");
            String password = request.getParameter("password");
            publisherDao dao = new publisherDao();
            publisher p = dao.publisherSignin(publisherID,password);
            if(p!=null){
                request.setAttribute("publisher",p);
                RequestDispatcher rd = request.getRequestDispatcher("showPublisher.jsp");
                rd.forward(request,response);
            }else{
                publisherError error = new publisherError();
                error.setLoginError(true);
                error.setOldPasswordError(false);
                error.setNewPasswordError(false);
                request.setAttribute("error",error);
                RequestDispatcher rd = request.getRequestDispatcher("login_publisher.jsp");
                rd.forward(request,response);
            }
        }
        if(request.getParameter("games")!=null){
            String publisherID = request.getParameter("publisherID");
            publisherDao dao2 = new publisherDao();
            publisher p = dao2.getPublisher(publisherID);
            gameDao dao = new gameDao();
            ArrayList<game> games = dao.getGamesByPublisherID(publisherID);
            if(!games.isEmpty()){
                request.setAttribute("games",games);
                request.setAttribute("publisher",p);
                RequestDispatcher rd = request.getRequestDispatcher("showPublisherGames.jsp");
                rd.forward(request,response);
            }
        }
        if(request.getParameter("showPlayers")!=null){
            String publisherID = request.getParameter("publisherID");
            String gameID = request.getParameter("gameID");
            publisherDao dao = new publisherDao();
            publisher p = dao.getPublisher(publisherID);
            playerDao dao2 = new playerDao();
            gameDao dao3 = new gameDao();
            game g = dao3.getGame(Integer.parseInt(gameID));
            ArrayList<player> players = new ArrayList<>();
            players = (ArrayList<player>) dao2.getPlayersByGameID(Integer.parseInt(gameID));
            if(!players.isEmpty()){
                request.setAttribute("players",players);
                request.setAttribute("game", g);
                RequestDispatcher rd = request.getRequestDispatcher("showPublisherGamePlayers.jsp");
                rd.forward(request,response);
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

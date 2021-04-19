package com.PC_Games_DB;

import com.PC_Games_DB.errors.playerEditProfileError;
import com.PC_Games_DB.players.player;
import com.PC_Games_DB.players.dao.playerDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

import com.PC_Games_DB.games.game;
import com.PC_Games_DB.games.dao.gameDao;

@WebServlet(name = "getPlayer", value = "/getPlayer")
public class getPlayer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("login")!=null){
            String gamerID = request.getParameter("gamerID");
            String password = request.getParameter("password");
            playerDao dao = new playerDao();
            player p = dao.playerSignin(gamerID,password);
            if(p!=null){
                request.setAttribute("player",p);
                RequestDispatcher rd = request.getRequestDispatcher("showPlayer.jsp");
                rd.forward(request,response);
            }else{
                playerEditProfileError error = new playerEditProfileError();
                error.setOldPasswordError(true);
                error.setNewPasswordError(false);
                request.setAttribute("error",error);
                RequestDispatcher rd = request.getRequestDispatcher("login_player.jsp");
                rd.forward(request,response);

            }
        }
        if(request.getParameter("games")!=null){
            String gamerID = request.getParameter("gamerID");
            gameDao dao = new gameDao();
            ArrayList<game> games = dao.getGamesByGamerID(gamerID);
            playerDao dao2 = new playerDao();
            player p = dao2.getPlayer(gamerID);

            request.setAttribute("games",games);

            request.setAttribute("player",p);
            RequestDispatcher rd = request.getRequestDispatcher("showPlayerGames.jsp");
            rd.forward(request,response);


        }
        if(request.getParameter("profile")!=null) {
            String gamerID = request.getParameter("gamerID");
            playerDao dao = new playerDao();
            player p = dao.getPlayer(gamerID);
            if(p!=null){
                request.setAttribute("player",p);
                RequestDispatcher rd = request.getRequestDispatcher("showPlayerProfile.jsp");
                rd.forward(request,response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

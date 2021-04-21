package com.PC_Games_DB;

import com.PC_Games_DB.games.dao.gameDao;
import com.PC_Games_DB.games.Game;

import com.PC_Games_DB.players.dao.playerDao;
import com.PC_Games_DB.players.player;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "getGame", value = "/getGame")
public class getGame extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("gamesListPlayer")!=null){
            String gamerID = request.getParameter("gamerID");
            playerDao dao2 = new playerDao();
            player p = dao2.getPlayer(gamerID);
            gameDao dao = new gameDao();
            ArrayList<Game> games = dao.getAllGamesForPlayer();
            request.setAttribute("games",games);
            request.setAttribute("player",p);
            RequestDispatcher rd =request.getRequestDispatcher("showGamesForPlayer.jsp");
            rd.forward(request,response);
        }
        if(request.getParameter("gamesListPlayerNamesAsc")!=null){
            String gamerID = request.getParameter("gamerID");
            playerDao dao2 = new playerDao();
            player p = dao2.getPlayer(gamerID);
            gameDao dao = new gameDao();
            ArrayList<Game> games = dao.getAllGamesForPlayerNamesAsc();
            request.setAttribute("games",games);
            request.setAttribute("player",p);
            RequestDispatcher rd =request.getRequestDispatcher("showGamesForPlayer.jsp");
            rd.forward(request,response);
        }
        if(request.getParameter("gamesListPlayerNamesDesc")!=null){
            String gamerID = request.getParameter("gamerID");
            playerDao dao2 = new playerDao();
            player p = dao2.getPlayer(gamerID);
            gameDao dao = new gameDao();
            ArrayList<Game> games = dao.getAllGamesForPlayerNamesDesc();
            request.setAttribute("games",games);
            request.setAttribute("player",p);
            RequestDispatcher rd =request.getRequestDispatcher("showGamesForPlayer.jsp");
            rd.forward(request,response);
        }
        if(request.getParameter("gamesListPlayerYearsAsc")!=null){
            String gamerID = request.getParameter("gamerID");
            playerDao dao2 = new playerDao();
            player p = dao2.getPlayer(gamerID);
            gameDao dao = new gameDao();
            ArrayList<Game> games = dao.getAllGamesForPlayerYearsAsc();
            request.setAttribute("games",games);
            request.setAttribute("player",p);
            RequestDispatcher rd =request.getRequestDispatcher("showGamesForPlayer.jsp");
            rd.forward(request,response);
        }
        if(request.getParameter("gamesListPlayerYearsDesc")!=null){
            String gamerID = request.getParameter("gamerID");
            playerDao dao2 = new playerDao();
            player p = dao2.getPlayer(gamerID);
            gameDao dao = new gameDao();
            ArrayList<Game> games = dao.getAllGamesForPlayerYearsDesc();
            request.setAttribute("games",games);
            request.setAttribute("player",p);
            RequestDispatcher rd =request.getRequestDispatcher("showGamesForPlayer.jsp");
            rd.forward(request,response);
        }
        if(request.getParameter("gamesListPlayerSearchYear")!=null){
            String gamerID = request.getParameter("gamerID");
            String year = request.getParameter("year");
            playerDao dao2 = new playerDao();
            player p = dao2.getPlayer(gamerID);
            gameDao dao = new gameDao();
            ArrayList<Game> games = dao.getAllGamesForPlayerSearchYear(Integer.parseInt(year));
            request.setAttribute("games",games);
            request.setAttribute("player",p);
            RequestDispatcher rd =request.getRequestDispatcher("showGamesForPlayer.jsp");
            rd.forward(request,response);
        }
        if(request.getParameter("gamesListPlayerSearchGenre")!=null){
            String gamerID = request.getParameter("gamerID");
            String genre = request.getParameter("genre");
            playerDao dao2 = new playerDao();
            player p = dao2.getPlayer(gamerID);
            gameDao dao = new gameDao();
            ArrayList<Game> games = dao.getAllGamesForPlayerSearchGenre(genre);
            request.setAttribute("games",games);
            request.setAttribute("player",p);
            RequestDispatcher rd =request.getRequestDispatcher("showGamesForPlayer.jsp");
            rd.forward(request,response);
        }
        if(request.getParameter("gamesListPlayerSearchName")!=null){
            String gamerID = request.getParameter("gamerID");
            String name = request.getParameter("name");
            playerDao dao2 = new playerDao();
            player p = dao2.getPlayer(gamerID);
            gameDao dao = new gameDao();
            ArrayList<Game> games = dao.getAllGamesForPlayerSearchName(name);
            request.setAttribute("games",games);
            request.setAttribute("player",p);
            RequestDispatcher rd =request.getRequestDispatcher("showGamesForPlayer.jsp");
            rd.forward(request,response);
        }
        if(request.getParameter("gamesListPlayerSearchPlatform")!=null){
            String gamerID = request.getParameter("gamerID");
            String platform = request.getParameter("platform");
            playerDao dao2 = new playerDao();
            player p = dao2.getPlayer(gamerID);
            gameDao dao = new gameDao();
            ArrayList<Game> games = dao.getAllGamesForPlayerSearchPlatform(platform);
            request.setAttribute("games",games);
            request.setAttribute("player",p);
            RequestDispatcher rd =request.getRequestDispatcher("showGamesForPlayer.jsp");
            rd.forward(request,response);
        }
        /*
        int gameID = Integer.parseInt(request.getParameter("gameID"));
        gameDao dao = new gameDao();
        game g1 = dao.getGame(gameID);

        request.setAttribute("game",g1);
        RequestDispatcher rd = request.getRequestDispatcher("showGame.jsp");
        rd.forward(request,response);

        */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

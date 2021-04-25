package com.PC_Games_DB;

import com.PC_Games_DB.games.dao.gameDao;
import com.PC_Games_DB.players.dao.playerDao;
import com.PC_Games_DB.players.player;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "removeGame", value = "/removeGame")
public class RemoveGame extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gamerID = request.getParameter("gamerID");
        String gameID = request.getParameter("gameID");

        gameDao gd = new gameDao();
        playerDao dao = new playerDao();
        player p = dao.getPlayer(gamerID);
        dao.removeGame(gamerID, gameID);

        request.setAttribute("games", gd.getGamesByGamerID(gamerID));

        request.setAttribute("player", p);
        RequestDispatcher rd = request.getRequestDispatcher("showPlayerGames.jsp");
        rd.forward(request, response);

    }

}

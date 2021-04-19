package com.PC_Games_DB;

import com.PC_Games_DB.players.dao.playerDao;
import com.PC_Games_DB.players.player;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "addGame", value = "/addGame")
public class addGame extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gamerID = request.getParameter("gamerID");
        String gameID = request.getParameter("gameID");
        playerDao dao = new playerDao();
        player p = dao.getPlayer(gamerID);
        dao.addGame(gamerID,gameID);
        request.setAttribute("player",p);
        RequestDispatcher rd =request.getRequestDispatcher("showPlayer.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

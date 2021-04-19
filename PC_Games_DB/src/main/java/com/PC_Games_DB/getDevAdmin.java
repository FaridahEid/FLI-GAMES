package com.PC_Games_DB;


import com.PC_Games_DB.games.dao.gameDao;
import com.PC_Games_DB.games.game;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import com.PC_Games_DB.dev_admins.dao.devAdminDao;
import com.PC_Games_DB.dev_admins.devAdmin;

@WebServlet(name = "getDevAdmin", value = "/getDevAdmin")
public class getDevAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("login")!=null){
            String adminID = request.getParameter("adminID");
            String password = request.getParameter("password");
            devAdminDao dao = new devAdminDao();
            devAdmin d = dao.devAdminSignin(adminID,password);
            if(d!=null){
                request.setAttribute("devAdmin",d);
                RequestDispatcher rd = request.getRequestDispatcher("showDevAdmin.jsp");
                rd.forward(request,response);
            }else{
                System.out.println("invalid information");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

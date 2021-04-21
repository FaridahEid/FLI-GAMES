package com.PC_Games_DB;


import com.PC_Games_DB.errors.PlayerEditProfileError;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

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
                PlayerEditProfileError error = new PlayerEditProfileError();
                error.setOldPasswordError(true);
                error.setNewPasswordError(false);
                request.setAttribute("error", error);
                RequestDispatcher rd = request.getRequestDispatcher("login_admin.jsp");
                rd.forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

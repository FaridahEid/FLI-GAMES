package com.PC_Games_DB;

import com.PC_Games_DB.errors.PublisherError;
import com.PC_Games_DB.publishers.dao.publisherDao;
import com.PC_Games_DB.publishers.publisher;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "editPublisher", value = "/editPublisher")
public class editPublisher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String publisherID = request.getParameter("publisherID");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        publisherDao dao = new publisherDao();
        publisher p = dao.getPublisher(publisherID);
        if(dao.checkPassword(publisherID,oldPassword)){
            if(newPassword.length()>7){
                boolean x = dao.changePassword(publisherID,newPassword);
                request.setAttribute("publisher",p);
                RequestDispatcher rd =request.getRequestDispatcher("showPublisher.jsp");
                rd.forward(request,response);
            }else{
                PublisherError error = new PublisherError();
                error.setNewPasswordError(true);
                error.setLoginError(false);
                error.setOldPasswordError(false);
                request.setAttribute("publisher",p);
                request.setAttribute("error",error);
                RequestDispatcher rd =request.getRequestDispatcher("showPublisher.jsp");
                rd.forward(request,response);
            }
        }else{
            PublisherError error = new PublisherError();
            error.setNewPasswordError(false);
            error.setLoginError(false);
            error.setOldPasswordError(true);
            request.setAttribute("publisher",p);
            request.setAttribute("error",error);
            RequestDispatcher rd =request.getRequestDispatcher("showPublisher.jsp");
            rd.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

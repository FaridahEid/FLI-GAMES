package com.PC_Games_DB;

import com.PC_Games_DB.dev_admins.DevAdmin;
import com.PC_Games_DB.dev_admins.dao.DevAdminDao;
import com.PC_Games_DB.errors.DevAdminError;
import com.PC_Games_DB.errors.PlayerEditProfileError;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "editDevAdmin", value = "/editDevAdmin")
public class EditDevAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminID = request.getParameter("adminID");

        if (request.getParameter("changeEmail") != null) {
            String email = request.getParameter("email");
            DevAdminDao dao = new DevAdminDao();
            DevAdmin d = dao.getDevAdmin(adminID);

            dao.changeEmail(adminID, email);
            request.setAttribute("devAdmin", d);

            RequestDispatcher rd = request.getRequestDispatcher("showDevAdmin.jsp");
            rd.forward(request, response);
        }
        else if (request.getParameter("changePassword") != null) {
            String oldPassword = request.getParameter("oldPassword");
            DevAdminDao dao = new DevAdminDao();
            DevAdmin d = dao.getDevAdmin(adminID);

            if (dao.checkPassword(adminID, oldPassword)) {
                String newPassword = request.getParameter("newPassword");
                if (newPassword.length() > 7) {
                    dao.changePassword(adminID, newPassword);
                    request.setAttribute("devAdmin", d);
                    RequestDispatcher rd = request.getRequestDispatcher("showDevAdmin.jsp");
                    rd.forward(request, response);
                } else {
                    DevAdminError error = new DevAdminError();
                    error.setNewPasswordError(true);

                    request.setAttribute("devAdmin", d);
                    request.setAttribute("error", error);
                    RequestDispatcher rd = request.getRequestDispatcher("showDevAdmin.jsp");
                    rd.forward(request, response);
                }
            } else {
                DevAdminError error = new DevAdminError();
                error.setOldPasswordError(true);

                request.setAttribute("devAdmin", d);
                request.setAttribute("error", error);
                RequestDispatcher rd = request.getRequestDispatcher("showDevAdmin.jsp");
                rd.forward(request, response);
            }
        }
    }
}

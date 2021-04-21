package com.PC_Games_DB;

import com.PC_Games_DB.errors.PlayerSignupError;
import com.PC_Games_DB.players.dao.playerDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "addPlayer", value = "/addPlayer")
public class addPlayer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gamerID = request.getParameter("gamerID");
        String gamerName = request.getParameter("gamerName");
        String DOB = request.getParameter("DOB");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //System.out.println(DOB);
        DOB = DOB.replaceAll("-","/");
        //System.out.println(DOB);
        String[] s = DOB.split("/");
        DOB = s[2] + "/" + s[1] + "/" + s[0];

        if(!checkGamerID(gamerID)){
            PlayerSignupError error = new PlayerSignupError();
            error.setGamerIDError(true);
            error.setEmailError(false);
            error.setDOBError(false);
            error.setPasswordError(false);
            error.setGamerIDTaken(false);
            request.setAttribute("error",error);
            RequestDispatcher rd =request.getRequestDispatcher("signup_player.jsp");
            rd.forward(request,response);
        }else if(password.length()<8){
            PlayerSignupError error = new PlayerSignupError();
            error.setGamerIDError(false);
            error.setEmailError(false);
            error.setDOBError(false);
            error.setPasswordError(true);
            error.setGamerIDTaken(false);
            request.setAttribute("error",error);
            RequestDispatcher rd =request.getRequestDispatcher("signup_player.jsp");
            rd.forward(request,response);
        }else if(!dobCheck(DOB)){
            PlayerSignupError error = new PlayerSignupError();
            error.setGamerIDError(false);
            error.setEmailError(false);
            error.setDOBError(true);
            error.setPasswordError(false);
            error.setGamerIDTaken(false);
            request.setAttribute("error",error);
            RequestDispatcher rd =request.getRequestDispatcher("signup_player.jsp");
            rd.forward(request,response);
        }
        else{
            playerDao dao = new playerDao();
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            String date_joined =dateFormat.format(date);
            if(dao.addPlayer(gamerID,gamerName,DOB,email,date_joined,password)){
                RequestDispatcher rd =request.getRequestDispatcher("login_player.jsp");
                rd.forward(request,response);
            }else{
                PlayerSignupError error = new PlayerSignupError();
                error.setGamerIDError(false);
                error.setEmailError(false);
                error.setDOBError(false);
                error.setPasswordError(false);
                error.setGamerIDTaken(true);
                request.setAttribute("error",error);
                RequestDispatcher rd =request.getRequestDispatcher("signup_player.jsp");
                rd.forward(request,response);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public static boolean isInt(String str){
        try {
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public static boolean checkGamerID(String str){
        if(str.length()!=9){
            return false;
        }else if(str.charAt(0)!='G'){
            return false;
        }else if(!isInt(str.substring(1))){
            return false;
        }else{
            return true;
        }
    }

    public static boolean dobCheck(String date){
        //System.out.println(date);
        String s = date.substring(date.length()-4);
        //System.out.println(s);
        int year = Integer.parseInt(s);
        if(year>2013){
            return false;
        }else{
            return true;
        }
    }
}

package com.PC_Games_DB.dev_admins.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.PC_Games_DB.dev_admins.devAdmin;


public class devAdminDao {
    public devAdmin getDevAdmin(String adminID){
        devAdmin a = new devAdmin();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from dev_admin where adminID=?");
            ps.setString(1,adminID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                a.setDevID(rs.getString("devID"));
                a.setAdminId(rs.getString("adminID"));
                a.setEmail(rs.getString("email"));
                a.setAdminName(rs.getString("adminName"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return a;
    }
    public devAdmin devAdminSignin(String adminID, String password){
        devAdmin a = new devAdmin();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from dev_admin where adminID=?");
            ps.setString(1,adminID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                a.setDevID(rs.getString("devID"));
                a.setAdminId(rs.getString("adminID"));
                a.setEmail(rs.getString("email"));
                a.setAdminName(rs.getString("adminName"));
            }
            PreparedStatement ps2 = con.prepareStatement("select * from login_d where adminID=?");
            ps2.setString(1,adminID);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2.next()){
                if(rs2.getString("password").equals(password)){
                    return a;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}

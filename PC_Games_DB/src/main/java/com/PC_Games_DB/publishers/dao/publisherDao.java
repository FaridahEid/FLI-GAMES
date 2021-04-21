package com.PC_Games_DB.publishers.dao;
import com.PC_Games_DB.publishers.publisher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class publisherDao {
    public publisher getPublisher(String publisherID){
        publisher p = new publisher();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from publishers where publisherID=?");
            ps.setString(1,publisherID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p.setPublisherID(rs.getString("publisherID"));
                p.setPname(rs.getString("pname"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return p;
    }
    public publisher publisherSignin(String publisherID, String password){
        publisher p = new publisher();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("select * from publishers where publisherID=?");
            ps.setString(1,publisherID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p.setPublisherID(rs.getString("publisherID"));
                p.setPname(rs.getString("pname"));
            }
            PreparedStatement ps2 = con.prepareStatement("select * from login_p where publisherID=?");
            ps2.setString(1,publisherID);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2.next()){
                if(rs2.getString("password").equals(password)){
                    return p;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    public boolean changePassword(String publisherID, String password){
        publisher p = new publisher();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps = con.prepareStatement("Update login_p SET password=? where publisherID=?");
            ps.setString(1,password);
            ps.setString(2,publisherID);
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    public boolean checkPassword(String publisherID, String password){
        publisher p = new publisher();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pc_games_db","root","loay1999");
            PreparedStatement ps2 = con.prepareStatement("select * from login_p where publisherID=?");
            ps2.setString(1,publisherID);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2.next()) {
                if(rs2.getString("password").equals(password)){
                    return true;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

}
